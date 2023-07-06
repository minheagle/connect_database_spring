package store.validators.lineItemValidator.update;

import store.entity.LineItem;

public interface IUpdateLineItemValidator {
    void validate(LineItem lineItem);
}
