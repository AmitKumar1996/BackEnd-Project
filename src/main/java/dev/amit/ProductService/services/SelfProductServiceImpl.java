package dev.amit.ProductService.services;

import dev.amit.ProductService.models.Product;
import org.springframework.stereotype.Service;

@Service("SelfProduceServiceImpl")
public class SelfProductServiceImpl  implements  ProductService{

    @Override
    public Product getProductById(Long Id) {
        return null;
    }
}
