package store.service.customer;

import store.DTO.CustomerDTO;
import store.entity.Customer;

import java.util.List;

public interface ICustomerService {
    List<CustomerDTO> getAll();
    CustomerDTO getById(long id);
    CustomerDTO create(Customer customer);
    CustomerDTO update(Customer customer);
    CustomerDTO delete(long id);
    void changePassword(long id, String oldPassword, String newPassword);
}
