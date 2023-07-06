package store.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.entity.Product;
import store.repository.ProductRepository;
import store.validators.productValidator.changeQuantity.IChangeProductQuantity;
import store.validators.productValidator.create.ICreateProductValidator;
import store.validators.productValidator.update.IUpdateProductValidator;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService{
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private List<ICreateProductValidator> createProductValidators;

    @Autowired
    private List<IUpdateProductValidator> updateProductValidators;

    @Autowired
    private IChangeProductQuantity changeProductQuantity;

    @Override
    public List<Product> getAll() {
        try {
            List<Product> listProduct = productRepository.findAll();
            if (listProduct.isEmpty()){
                throw new RuntimeException("Danh sách sản phẩm trống !");
            }
            return listProduct;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Product getById(long id) {
        try{
            Optional<Product> productById = productRepository.findById(id);
            if (productById.isEmpty()){
                throw new RuntimeException("Sản phẩm không tồn tại !");
            }
            return productById.get();
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Product create(Product newProduct) {
        try {
            createValidator(newProduct);
            return productRepository.save(newProduct);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    private void createValidator(Product product){
        createProductValidators.forEach(validator -> validator.validate(product));
    }

    @Override
    public Product update(Product updateProduct) {
        try {
            updateValidator(updateProduct);
            Optional<Product> getProductById = productRepository.findById(updateProduct.getId());
            if(getProductById.isEmpty()){
                throw new RuntimeException("Sản phẩm không tồn tại !");
            }
            getProductById.map(product -> {
                product.setName(updateProduct.getName());
                product.setPrice(updateProduct.getPrice());
                product.setQuantity(updateProduct.getQuantity());
                return productRepository.save(product);
            });
            return getProductById.get();
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Product changeQuantity(long id, int quantity) {
        try {
            Optional<Product> getProductById = productRepository.findById(id);
            if (getProductById.isEmpty()){
                throw new RuntimeException("Sản phẩm không tồn tại !");
            }
            validatorQuantity(id ,quantity);
            getProductById.map(product -> {
               product.setQuantity(product.getQuantity() - quantity);
               return productRepository.save(product);
            });
            return getProductById.get();
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    private void validatorQuantity(long id, int quantity){
        changeProductQuantity.changeQuantity(id ,quantity);
    }

    private void updateValidator(Product product){
        updateProductValidators.forEach(validator -> validator.validate(product));
    }

    @Override
    public void delete(long id) {
        try {
            if (productRepository.findById(id).isEmpty()){
                throw new RuntimeException("Sản phẩm không tồn tại !");
            }
            productRepository.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
