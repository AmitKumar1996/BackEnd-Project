package dev.amit.ProductService.services;

import org.springframework.stereotype.Service;

@Service("fakestoreproductservice")
public class FakeProductService  implements  ProductService{

    @Override
    public String getProductById(Long id) {
        return "Here is Product id: "+ id;
    }
}
