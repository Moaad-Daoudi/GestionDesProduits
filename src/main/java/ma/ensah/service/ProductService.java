package ma.ensah.service;

import java.util.List;

import ma.ensah.model.Product;

public interface ProductService {
	void addProduct(Product product);
    void deleteProduct(Long id);
    Product getProduct(Long id);
    List<Product> getAllProducts();
    void updateProduct(Product product);
}
