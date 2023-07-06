package store.validators.customerValidator.changePassword;

import org.springframework.stereotype.Component;

@Component
public class ValidateCustomerPassword implements IChangePasswordValidator{
    @Override
    public void validate(String password) {
        if (password.isEmpty()){
            throw new RuntimeException("Password không được để trống !");
        }
        if (password.length() < 8 || password.length() > 25){
            throw new RuntimeException("Password chứa 8-25 kí tự !");
        }
    }
}
