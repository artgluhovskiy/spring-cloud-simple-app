package org.art.web.micro.controllers;

import org.art.web.micro.entities.Product;
import org.art.web.micro.exceptions.ProductNotFoundException;
import org.art.web.micro.services.InventoryServiceClient;
import org.art.web.micro.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    private final InventoryServiceClient inventoryServiceClient;

    @Autowired
    public ProductController(ProductService productService, InventoryServiceClient inventoryServiceClient) {
        this.productService = productService;
        this.inventoryServiceClient = inventoryServiceClient;
    }

    @GetMapping
    public List<Product> allProducts() {
        return productService.findAllProducts();
    }

    @GetMapping("/{code}")
    public Product productByCode(@PathVariable String code) {
        return productService.findProductByCode(code)
                .orElseThrow(() -> new ProductNotFoundException("Product with code [" + code + "] doesn't exist"));
    }

    @GetMapping("/ext/{code}")
    public Product productByCodeExt(@PathVariable String code) {
        return inventoryServiceClient.getProductInventoryByCode(code).map(
                response -> new Product(0L, response.getProductCode(), "product", "description", 1.0, true))
                .orElseThrow(() -> new ProductNotFoundException("Product with code [" + code + "] doesn't exist"));
    }
}
