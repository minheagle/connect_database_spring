package store.validators.customerValidator.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import store.entity.Customer;
import store.repository.CustomerRepository;
import store.validators.customerValidator.create.ICreateCustomerValidator;
import store.validators.customerValidator.update.IUpdateCustomerValidator;

import java.util.ArrayList;
import java.util.List;

@Component
public class ValidateCustomerEmail implements ICreateCustomerValidator, IUpdateCustomerValidator {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void validate(Customer customer) {
        if (!checkTypeEmail(customer)){
            throw new RuntimeException("Định dạng của email không được phép !");
        }
        if (customer.getEmail().split("@")[0].isEmpty()){
            throw new RuntimeException("Email không hợp lệ !");
        }
        if (customerRepository.existsByEmail(customer.getEmail())){
            throw new RuntimeException("Email đã tồn tại !");
        }
    }

    private boolean checkTypeEmail(Customer customer){
        List<String> listTypeAccept = new ArrayList<>();
        listTypeAccept.add("gmail.com");
        listTypeAccept.add("outlook.com");
        listTypeAccept.add("yahoo.com");

        boolean isCheck = false;
        for (String item : listTypeAccept) {
            if (customer.getEmail().endsWith(item)){
                isCheck = true;
                break;
            }
        }
        return isCheck;
    }
}
