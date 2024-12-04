package dev.amit.ProductService.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.rmi.server.UID;
import java.util.UUID;

@RestController

@RequestMapping("/products")


public class ProductController {
// localhost:8080/products/123
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
