package dev.amit.ProductService.services;

import dev.amit.ProductService.dtos.GenericProductDto;
import org.springframework.stereotype.Service;

@Service("selfproduceserviceimpl")
public class SelfProductServiceImpl  implements  ProductService{

    @Override
    public GenericProductDto getProductById(Long Id) {
        return null;
    }
}
