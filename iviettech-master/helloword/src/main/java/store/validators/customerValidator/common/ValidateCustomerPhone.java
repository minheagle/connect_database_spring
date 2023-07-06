package store.validators.customerValidator.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import store.entity.Customer;
import store.repository.CustomerRepository;
import store.validators.customerValidator.create.ICreateCustomerValidator;
import store.validators.customerValidator.update.IUpdateCustomerValidator;

@Component
public class ValidateCustomerPhone implements ICreateCustomerValidator, IUpdateCustomerValidator {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void validate(Customer customer) {
        if(!customer.getPhone().startsWith("0") || customer.getPhone().length() != 10){
            throw new RuntimeException("Số điện thoại không hợp lệ");
        }
        if (customerRepository.existsByPhone(customer.getPhone())){
            throw new RuntimeException("Số điện thoại đã tồn tại !");
        }
    }
}
