package dev.amit.ProductService.services;

import dev.amit.ProductService.dtos.GenericProductDto;
import dev.amit.ProductService.models.Product;

import java.util.List;

public interface ProductService {


    GenericProductDto createProduct(GenericProductDto product);

    List<Product> getAllProduct();

    GenericProductDto deleteProductById(Long id);

    GenericProductDto getProductById(Long Id);

}
