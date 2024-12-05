package dev.amit.ProductService.services;

import dev.amit.ProductService.models.Product;
import org.springframework.stereotype.Service;

@Service

public class FakeStoreProductService implements  ProductService{



    @Override
    public Product SgetProductById(Long Id) {
        return new Product();
    }
}
