package org.art.web.micro.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.art.web.micro.entities.Product;
import org.art.web.micro.repositories.ProductRepository;
import org.art.web.micro.services.ProductService;
import org.art.web.micro.vo.ProductInventoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, RestTemplate restTemplate) {
        this.productRepository = productRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findProductByCode(String code) {
        Optional<Product> product = productRepository.findByCode(code);
        if (product.isPresent()) {
            log.info("Fetching inventory level for product_code: " + code);
            ResponseEntity<ProductInventoryResponse> itemResponseEntity =
                    restTemplate.getForEntity("http://inventory-service/api/inventory/{code}",
                            ProductInventoryResponse.class,
                            code);
            if (itemResponseEntity.getStatusCode() == HttpStatus.OK) {
                int quantity = itemResponseEntity.getBody().getAvailableQuantity();
                log.info("Available quantity: " + quantity);
                product.get().setInStock(quantity > 0);
            } else {
                log.error("Unable to get inventory level for product_code: " + code +
                        ", StatusCode: " + itemResponseEntity.getStatusCode());
            }
        }
        return product;
    }
}
