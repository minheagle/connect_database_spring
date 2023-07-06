package store.service.customer;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import store.DTO.CustomerDTO;
import store.entity.Customer;
import store.repository.CustomerRepository;
import store.validators.customerValidator.changePassword.IChangePasswordValidator;
import store.validators.customerValidator.create.ICreateCustomerValidator;
import store.validators.customerValidator.update.IUpdateCustomerValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private List<ICreateCustomerValidator> createValidators;

    @Autowired
    private List<IUpdateCustomerValidator> updateValidators;

    @Autowired
    private IChangePasswordValidator changePasswordValidator;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<CustomerDTO> getAll() {
        List<Customer> listCustomer = customerRepository.findAll();
        if(listCustomer.isEmpty()){
            throw new RuntimeException("Danh sách người dùng rỗng");
        }
        List<CustomerDTO> listCustomerDTO = new ArrayList<>();
        for (Customer customer : listCustomer) {
            listCustomerDTO.add(modelMapper.map(customer, CustomerDTO.class));
        }
        return listCustomerDTO;
    }

    @Override
    public CustomerDTO getById(long id) {
        try{
            Optional<Customer> customerById = customerRepository.findById(id);
            if (customerById.isEmpty()){
                throw new RuntimeException("Người dùng không tồn tại !");
            }
            return modelMapper.map(customerById.get(), CustomerDTO.class);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public CustomerDTO create(Customer customer) {
        try{
            createValidate(customer);
            customer.setPassword(passwordEncoder.encode(customer.getPassword()));
            Customer responseCustomer =  customerRepository.save(customer);
            return modelMapper.map(responseCustomer, CustomerDTO.class);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    private void createValidate(final Customer customer){
        createValidators.forEach(validator -> validator.validate(customer));
    }

    @Override
    public CustomerDTO update(Customer customer) {
        try{
            updateValidate(customer);
            Optional<Customer> responseCustomer =  customerRepository.findById(customer.getId()).map(updateCustomer -> {
                updateCustomer.setName(customer.getName());
                updateCustomer.setAge(customer.getAge());
                updateCustomer.setAddress(customer.getAddress());
                updateCustomer.setPhone(customer.getPhone());
                updateCustomer.setEmail(customer.getEmail());
                updateCustomer.setRole(customer.getRole());
                return customerRepository.save(updateCustomer);
            });
            return modelMapper.map(responseCustomer.get(), CustomerDTO.class);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    private void updateValidate(Customer customer){
        updateValidators.forEach(validator -> validator.validate(customer));
    }

    @Override
    public CustomerDTO delete(long id) {
        try{
            Optional<Customer> checkCustomer = customerRepository.findById(id);
            if (checkCustomer.isEmpty()){
                throw new RuntimeException("Người dùng không tồn tại !");
            }
            customerRepository.delete(checkCustomer.get());
            return modelMapper.map(checkCustomer.get(), CustomerDTO.class);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void changePassword(long id, String oldPassword, String newPassword) {
        try{
            Optional<Customer> getCustomer = customerRepository.findById(id);
            if (getCustomer.isEmpty()){
                throw new RuntimeException("Người dùng không tồn tại !");
            }
            if(!passwordEncoder.matches(oldPassword, getCustomer.get().getPassword())){
                throw new RuntimeException("Mật khẩu không chính xác !");
            }
            changePasswordValidator.validate(newPassword);
            getCustomer.map(updateCustomer -> {
               updateCustomer.setPassword(passwordEncoder.encode(newPassword));
               return customerRepository.save(updateCustomer);
            });
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
