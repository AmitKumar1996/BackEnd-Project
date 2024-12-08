package dev.amit.ProductService.services;

import dev.amit.ProductService.dtos.GenericProductDto;
import dev.amit.ProductService.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfproduceserviceimpl")
public class SelfProductServiceImpl  implements  ProductService{

    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        return null;
    }

    @Override
    public List<Product> getAllProduct() {
        return List.of();
    }

    @Override
    public GenericProductDto getProductById(Long Id) {
        return null;
    }
}
