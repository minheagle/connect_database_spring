package store.validators.customerValidator.create;

import store.entity.Customer;

public interface ICreateCustomerValidator {
    void validate(Customer customer);
}
