package org.art.web.micro.services;

import org.art.web.micro.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAllProducts();

    Optional<Product> findProductByCode(String code);
}
