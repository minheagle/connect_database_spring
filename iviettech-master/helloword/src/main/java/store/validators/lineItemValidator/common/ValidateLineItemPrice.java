package store.validators.lineItemValidator.common;

import org.springframework.stereotype.Component;
import store.entity.LineItem;
import store.validators.lineItemValidator.create.ICreateLineItemValidator;
import store.validators.lineItemValidator.update.IUpdateLineItemValidator;

@Component
public class ValidateLineItemPrice implements ICreateLineItemValidator, IUpdateLineItemValidator {
    @Override
    public void validate(LineItem lineItem) {
        if (lineItem.getPrice() == 0){
            throw new RuntimeException("Chưa có giá của sản phẩm !");
        }
    }
}
