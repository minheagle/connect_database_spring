package store.validators.customerValidator.common;

import org.springframework.stereotype.Component;
import store.entity.Customer;
import store.validators.customerValidator.create.ICreateCustomerValidator;
import store.validators.customerValidator.update.IUpdateCustomerValidator;

@Component
public class ValidateCustomerAge implements ICreateCustomerValidator, IUpdateCustomerValidator {
    @Override
    public void validate(Customer customer) {
        if (customer.getAge() == 0){
            throw new RuntimeException("Tuổi không được để trống !");
        }
        if (customer.getAge() < 18 || customer.getAge() > 100){
            throw new RuntimeException("Độ tuổi của bạn không phù hợp !");
        }
    }
}
