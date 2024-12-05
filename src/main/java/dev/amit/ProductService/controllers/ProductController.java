package dev.amit.ProductService.controllers;

import dev.amit.ProductService.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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

/*
    // Field Method DI
     @Autowired          // agar @Autowired lagayenge to bhi chale ga spring automatically put in latest version
    private ProductService productService;
*/





     // Constructer Method DI(Best Approcah more redable)
     public ProductController(ProductService productService){
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
