package store.validators.productValidator.common;

import org.springframework.stereotype.Component;
import store.entity.Product;
import store.validators.productValidator.create.ICreateProductValidator;
import store.validators.productValidator.update.IUpdateProductValidator;

@Component
public class ValidateProductQuantity implements ICreateProductValidator, IUpdateProductValidator {
    @Override
    public void validate(Product product) {
        if (product.getQuantity() < 0){
            throw new RuntimeException("Số lượng của sản phẩm phải là số lớn hoặc bằng 0");
        }
    }
}
