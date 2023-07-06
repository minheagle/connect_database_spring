package store.service.line_item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.entity.LineItem;
import store.repository.LineItemRepository;

import java.util.List;

@Service
public class LineItemService implements ILineItemService{
    @Autowired
    private LineItemRepository lineItemRepository;

    @Override
    public List<LineItem> getAll() {
        try {
            List<LineItem> listAllLineItem = lineItemRepository.findAll();
            if (listAllLineItem.isEmpty()){
                throw new RuntimeException("Danh sách trống !");
            }
            return listAllLineItem;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<LineItem> getAllByOrderId(long orderId) {
        try {
            List<LineItem> list = lineItemRepository.findAllByOrderId(orderId);
            if (list.isEmpty()){
                throw new RuntimeException("Danh sách trống !");
            }
            return list;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public LineItem create(LineItem lineItem) {
        return null;
    }

    @Override
    public LineItem update(LineItem lineItem) {
        return null;
    }

    @Override
    public void delete(long id) {

    }
}
