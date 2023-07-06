package store.validators.productValidator.changeQuantity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import store.repository.ProductRepository;

@Component
public class ChangeProductQuantity implements IChangeProductQuantity{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public void changeQuantity(long id, int quantity) {
        if(quantity <= 0){
            throw new RuntimeException("Vui lòng chọn số lớn hơn 0 !");
        }
        if (productRepository.findById(id).get().getQuantity() < quantity){
            throw new RuntimeException("Bạn đã chọn số lượng vượt quá hàng tồn kho !");
        }
    }
}
