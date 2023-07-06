package store.validators.productValidator.create;

import store.entity.Product;

public interface ICreateProductValidator {
    void validate(Product product);
}
