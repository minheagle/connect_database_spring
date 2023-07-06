package store.validators.customerValidator.common;

import org.springframework.stereotype.Component;
import store.entity.Customer;
import store.validators.customerValidator.create.ICreateCustomerValidator;
import store.validators.customerValidator.update.IUpdateCustomerValidator;

@Component
public class ValidateCustomerName implements ICreateCustomerValidator, IUpdateCustomerValidator {
    @Override
    public void validate(Customer customer) {
        if (customer.getName().isEmpty()){
            throw new RuntimeException("Tên không được để trống !");
        }
        if (customer.getName().length() > 255){
            throw new RuntimeException("Độ dài không được quá 255 kí tự !");
        }
    }
}
