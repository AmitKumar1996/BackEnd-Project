package dev.amit.ProductService.services;

import dev.amit.ProductService.dtos.GenericProductDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("selfproduceserviceimpl")
public class SelfProductServiceImpl  implements  ProductService{

    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        return null;
    }

    @Override
    public GenericProductDto updateProductById(Long id) {
        return null;
    }

//    @Override
//    public List<GenericProductDto> getAllProduct() {
//        return List.of();
//    }

//    @Override
//    public GenericProductDto deleteProductById(Long id) {
//        return null;
//    }

    @Override
    public GenericProductDto getProductById(Long Id) {
        return null;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        return null;
    }

    @Override
    public GenericProductDto deleteProduct(Long id) {
        return null;
    }
}
