package dev.amit.ProductService.services;

import dev.amit.ProductService.dtos.GenericProductDto;
import dev.amit.ProductService.repository.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
@Primary
@Service("selfproduceserviceimpl")
public class SelfProductServiceImpl  implements  ProductService{

    private ProductRepository productRepository;

    public SelfProductServiceImpl(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

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
