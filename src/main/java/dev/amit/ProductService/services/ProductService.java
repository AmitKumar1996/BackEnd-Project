package dev.amit.ProductService.services;

import dev.amit.ProductService.dtos.GenericProductDto;

public interface ProductService {


    GenericProductDto createProduct(GenericProductDto product);

    GenericProductDto getProductById(Long Id);

}
