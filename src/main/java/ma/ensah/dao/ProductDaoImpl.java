package ma.ensah.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import ma.ensah.model.Product;

public class ProductDaoImpl implements IProduct{

	private static Map<Long, Product> productMap = new ConcurrentHashMap<>();
    private static AtomicLong idCounter = new AtomicLong(1);

    @Override
    public void add(Product product) {
        product.setId(idCounter.getAndIncrement());
        productMap.put(product.getId(), product);
    }

    @Override
    public void delete(Long id) {
        productMap.remove(id);
    }

    @Override
    public Product findById(Long id) {
        return productMap.get(id);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void update(Product product) {
        productMap.put(product.getId(), product);
    }

}
