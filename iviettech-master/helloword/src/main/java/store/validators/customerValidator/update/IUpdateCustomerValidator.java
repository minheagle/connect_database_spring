package store.validators.customerValidator.update;

import store.entity.Customer;

public interface IUpdateCustomerValidator {
    void validate(Customer customer);
}
