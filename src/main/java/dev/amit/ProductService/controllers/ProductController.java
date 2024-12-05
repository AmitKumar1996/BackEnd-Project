package dev.amit.ProductService.controllers;

import dev.amit.ProductService.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.rmi.server.UID;
import java.security.PrivateKey;
import java.util.UUID;

@RestController

@RequestMapping("/products")


public class ProductController {






/*-----------------------------------------------------------------------------------------------------------------------------------------------------------*/

    /*
       Dependency Injection
       1. Setter Method DI
       2. Constructor Method DI
       3. Field Method DI
    */


    // Field Method DI
     @Autowired          // agar @Autowired nhi lagayenge to bhi chale ga spring automatically put kar deta hai  in latest version of SpringBoot
    private ProductService productService;






     // Constructer Method DI(Best Approcah more redable code)
    // we can also declare variable in application.property file to make dynamic use of resolving ambiguaty using    @Value("${FakeStoreProductService}")
    // Latest Version of Spring me @Auotowired ka koe farke nhi parta hai
     public ProductController(@Qualifier("FakeStoreProductService") ProductService productService){
         this.productService= productService;
     }




/*
     // Seter Method DI
    @Autowired
    public void setProductService(ProductService productService){
        this.productService = productService;
    }
*/

 /*-----------------------------------------------------------------------------------------------------------------------------------------------------------*/



// localhost:8080/products/123
// localhost:8080/product?id=123
    @GetMapping
    public void getAllProducts(){

    }

    @GetMapping("/{id}")
    public String getProductById( @PathVariable("id") Long id){

        return "Here is the product Id : "+id;

    }

    @DeleteMapping("/{id}")
    public void deleteProductById(){

    }

    @PostMapping
    public String createProduct(){

        return "Created new Prodct: "+ UUID.randomUUID();



    }

    @PutMapping("/{id}")
    public void updateProductById(){

    }
}
