package dev.amit.ProductService.services;

import dev.amit.ProductService.dtos.GenericProductDto;

public interface ProductService {


    GenericProductDto getProductById(Long Id);

}
