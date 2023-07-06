package store.validators.customerValidator.common;

import org.springframework.stereotype.Component;
import store.entity.Customer;
import store.validators.customerValidator.create.ICreateCustomerValidator;
import store.validators.customerValidator.update.IUpdateCustomerValidator;

@Component
public class ValidateCustomerAddress implements ICreateCustomerValidator, IUpdateCustomerValidator {
    @Override
    public void validate(Customer customer) {
        if (customer.getAddress().length() > 255){
            throw new RuntimeException("Độ dài không được vượt quá 255 kí tự !");
        }
    }
}
