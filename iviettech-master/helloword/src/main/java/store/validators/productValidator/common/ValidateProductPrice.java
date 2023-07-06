package store.validators.productValidator.common;

import org.springframework.stereotype.Component;
import store.entity.Product;
import store.validators.productValidator.create.ICreateProductValidator;
import store.validators.productValidator.update.IUpdateProductValidator;

@Component
public class ValidateProductPrice implements ICreateProductValidator, IUpdateProductValidator {
    @Override
    public void validate(Product product) {
        if (product.getPrice() == 0){
            throw new RuntimeException("Giá của sản phẩm không được để trống !");
        }
    }
}
