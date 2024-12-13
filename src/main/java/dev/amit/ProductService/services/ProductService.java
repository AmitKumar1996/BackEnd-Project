package dev.amit.ProductService.services;

import dev.amit.ProductService.dtos.GenericProductDto;
import dev.amit.ProductService.exceptions.NotFoundException;

import java.util.List;

public interface ProductService {


    GenericProductDto createProduct(GenericProductDto product);

    //   List<GenericProductDto> getAllProduct();

    //  GenericProductDto deleteProductById(Long id);

    /*-----------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    GenericProductDto updateProductById(Long id);

  //  GenericProductDto deleteProductById(Long id);

    GenericProductDto getProductById(Long Id) throws NotFoundException;

    //   GenericProductDto deleteProductById();

   List<GenericProductDto> getAllProducts();


  GenericProductDto deleteProduct(Long id);

}
