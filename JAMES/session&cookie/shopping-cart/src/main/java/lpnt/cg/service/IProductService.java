package lpnt.cg.service;

import lpnt.cg.model.Product;

import java.util.Optional;

public interface IProductService {

    Iterable<Product> findAll();

    Optional<Product> findById(Long id);
}
