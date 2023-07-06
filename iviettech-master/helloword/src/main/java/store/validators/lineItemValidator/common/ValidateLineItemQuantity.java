package store.validators.lineItemValidator.common;

import store.entity.LineItem;
import store.validators.lineItemValidator.create.ICreateLineItemValidator;
import store.validators.lineItemValidator.update.IUpdateLineItemValidator;

public class ValidateLineItemQuantity implements ICreateLineItemValidator, IUpdateLineItemValidator {
    @Override
    public void validate(LineItem lineItem) {
        if (lineItem.getQuantity() == 0){
            throw new RuntimeException("Số lượng của sản phẩm phải lớn hơn 0 !");
        }
    }
}
