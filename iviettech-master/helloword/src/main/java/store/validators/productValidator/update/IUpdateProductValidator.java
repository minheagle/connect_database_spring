package store.validators.productValidator.update;

import store.entity.Product;

public interface IUpdateProductValidator {
    void validate(Product product);
}
