package ma.ensah.dao;

import java.util.List;

import ma.ensah.model.Product;

public interface IProduct {
	void add(Product product);
    void delete(Long id);
    Product findById(Long id);
    List<Product> findAll();
    void update(Product product);
}
