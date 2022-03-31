package lpnt.services;

import lpnt.model.Product;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService implements IProductService {
    private static  final Map<Integer, Product> products;
    static {
        products = new HashMap<>();
        products.put(1, new Product(1,"Massage LOVE", 5000234,"Sp demo", "VN"));
        products.put(2, new Product(2,"Massage TY",8666666, "Sp ngung ban", "US"));
        products.put(3, new Product(3,"Massage VN",7666666,"SP vip","JP"));
        products.put(4, new Product(4,"Massage 3",98888888,"SP error","Cam"));
        products.put(5, new Product(5,"Massage 5",866666666,"SP GOod","Laos"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product findById(int id) {
    return products.get(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> listProduct = new ArrayList<>(products.values());
        List<Product> listSearch = new ArrayList<>();
        name = name.toLowerCase();
        for (Product product : listProduct) {
            if(product.getName().toLowerCase().contains(name)) {
                listSearch.add(product);
            }
        }
        return listSearch;
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
