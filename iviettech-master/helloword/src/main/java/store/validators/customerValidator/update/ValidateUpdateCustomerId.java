package store.validators.customerValidator.update;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import store.entity.Customer;
import store.repository.CustomerRepository;
import store.validators.customerValidator.create.ICreateCustomerValidator;

@Component
public class ValidateUpdateCustomerId implements IUpdateCustomerValidator {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public void validate(Customer customer) {
        if (!customerRepository.existsById(customer.getId())){
            throw new RuntimeException("Customer không tồn tại !");
        }
    }
}
