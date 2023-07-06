package store.service.product;

import store.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();
    Product getById(long id);
    Product create(Product newProduct);
    Product update(Product updateProduct);

    Product changeQuantity(long id, int quantity);
    void delete(long id);
}
