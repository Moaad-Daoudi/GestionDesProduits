package ma.ensah.service;

import ma.ensah.dao.IProduct;
import ma.ensah.dao.ProductDaoImpl;
import ma.ensah.model.Product;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    
    // We reference the Interface, not the concrete implementation
    private IProduct productDao = new ProductDaoImpl();
    
    @Override
    public void addProduct(Product product) {
        productDao.add(product);
    }
    
    @Override
    public void deleteProduct(Long id) {
        productDao.delete(id);
    }
    
    @Override
    public Product getProduct(Long id) {
        return productDao.findById(id);
    }
    
    @Override
    public List<Product> getAllProducts() {
        return productDao.findAll();
    }
    
    @Override
    public void updateProduct(Product product) {
        productDao.update(product);
    }
}