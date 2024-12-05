package dev.amit.ProductService.services;

import dev.amit.ProductService.models.Product;
import org.springframework.stereotype.Service;

@Service("FakeStoreProductService")
public class FakeStoreProductService implements  ProductService{



    @Override
    public Product getProductById(Long Id) {
        return new Product();
    }
}
