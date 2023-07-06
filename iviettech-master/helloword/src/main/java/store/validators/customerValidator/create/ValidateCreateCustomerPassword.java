package store.validators.customerValidator.create;

import org.springframework.stereotype.Component;
import store.entity.Customer;

@Component
public class ValidateCreateCustomerPassword implements ICreateCustomerValidator {
    @Override
    public void validate(Customer customer) {
        if (customer.getPassword().isEmpty()){
            throw new RuntimeException("Password không được để trống !");
        }
        if (customer.getPassword().length() < 8 || customer.getPassword().length() > 25){
            throw new RuntimeException("Password chứa 8-25 kí tự !");
        }
    }
}
