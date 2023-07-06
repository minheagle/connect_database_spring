package store.service.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.entity.Order;
import store.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService implements IOrderService{
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public List<Order> getAll() {
        return null;
    }

    @Override
    public List<Order> getAllByUserId(long userId) {
        return null;
    }

    @Override
    public Order create(Order order) {
        return null;
    }

    @Override
    public Order update(Order order) {
        return null;
    }

    @Override
    public void delete(long id) {

    }
}
