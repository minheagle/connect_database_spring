package store.service.line_item;

import store.entity.LineItem;

import java.util.List;

public interface ILineItemService {
    List<LineItem> getAll();
    List<LineItem> getAllByOrderId(long orderId);
    LineItem create(LineItem lineItem);
    LineItem update(LineItem lineItem);
    void delete(long id);
}
