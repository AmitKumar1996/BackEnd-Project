package dev.amit.ProductService.services;

import dev.amit.ProductService.dtos.GenericProductDto;

import java.util.List;

public interface ProductService {


    GenericProductDto createProduct(GenericProductDto product);

    List<GenericProductDto> getAllProduct();

    GenericProductDto deleteProductById(Long id);

    GenericProductDto getProductById(Long Id);

}
