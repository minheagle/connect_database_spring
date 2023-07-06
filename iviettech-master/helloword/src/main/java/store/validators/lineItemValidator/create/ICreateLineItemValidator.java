package store.validators.lineItemValidator.create;

import store.entity.LineItem;

public interface ICreateLineItemValidator {
    void validate(LineItem lineItem);
}
