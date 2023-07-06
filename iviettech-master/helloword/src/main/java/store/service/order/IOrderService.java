package store.service.order;

import store.entity.Order;

import java.util.List;

public interface IOrderService {
    List<Order> getAll();
    List<Order> getAllByUserId(long userId);
    Order create(Order order);
    Order update(Order order);
    void delete(long id);
}
