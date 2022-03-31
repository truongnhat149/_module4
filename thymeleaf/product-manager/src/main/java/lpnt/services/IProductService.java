package lpnt.services;

import lpnt.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();

    Product findById(int id);

    List<Product> findByName(String name);

    void update(int id, Product product);

    void save(Product product);

    void remove(int id);


}
