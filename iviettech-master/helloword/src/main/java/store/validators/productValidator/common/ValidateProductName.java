package store.validators.productValidator.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import store.entity.Product;
import store.repository.ProductRepository;
import store.validators.productValidator.create.ICreateProductValidator;
import store.validators.productValidator.update.IUpdateProductValidator;

@Component
public class ValidateProductName implements ICreateProductValidator, IUpdateProductValidator {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void validate(Product product) {
        if (product.getName().isEmpty()){
            throw new RuntimeException("Tên của sản phẩm không được để trống !");
        }
        if (product.getName().length() > 255){
            throw new RuntimeException("Tên của sản phẩm không được vượt quá 255 kí tự !");
        }
        if (productRepository.existsByName(product.getName())){
            throw new RuntimeException("Sản phẩm đã tồn tại");
        }
    }
}
