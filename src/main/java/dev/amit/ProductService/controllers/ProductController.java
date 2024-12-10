package dev.amit.ProductService.controllers;

import dev.amit.ProductService.dtos.GenericProductDto;
import dev.amit.ProductService.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController

@RequestMapping("/products")


public class ProductController {


    Logger logger = Logger.getLogger(getClass().getName());



    /*-----------------------------------------------------------------------------------------------------------------------------------------------------------*/
    //* Every Anotation/ Spatial classes  ka spring boot  object create karta hai
    /*
       Dependency Injection
       1. Setter Method DI
       2. Constructor Method DI
       3. Field Method DI
    */


    // Field Method DI
//    @Autowired
//    @Qualifier("fakestoreproductservice")
//    // agar @Autowired nhi lagayenge to bhi chale ga spring automatically put kar deta hai  in latest version of SpringBoot
    private ProductService productService;


    // Constructer Method DI(Best Approcah more redable code)
    // we can also declare variable in application.property file to make dynamic use of resolving ambiguaty using    @Value("${FakeStoreProductService}")
    // Latest Version of Spring me @Auotowired ka koe farke nhi parta hai
    @Autowired

    public ProductController(@Qualifier("fakestoreproductservice") ProductService productService) {
        this.productService = productService;
    }




/*
     // Setter Method DI
    @Autowired
    public void setProductService(ProductService productService){
        this.productService = productService;
    }
*/

    /*-----------------------------------------------------------------------------------------------------------------------------------------------------------*/


//                                                                    Get All Product


    /*-----------------------------------------------------------------------------------------------------------------------------------------------------------*/

    // GET / Products {}
//   @GetMapping
//    public List<GenericProductDto>getAllProducts(){
//
//       return productService.getAllProducts();
//
//    }


// localhost:8080/products/123
// localhost:8080/product?id=123
//    @GetMapping
//    public List<GenericProductDto> getAllProducts() {
//       // System.out.println();
//        logger.info("hi all product 1");
//
//        List<GenericProductDto> allProduct = productService.getAllProduct();
//
//        return allProduct;
//
//        //return productService.getAllProduct();
//        //logger.info("hi all product bye");
//
//
//        // System.out.println("c1");
//        // task 3
//    }
    /*-----------------------------------------------------------------------------------------------------------------------------------------------------------*/


//                                                                         Get Product By Id


    /*-----------------------------------------------------------------------------------------------------------------------------------------------------------*/
    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) {
        // System.out.println("controller");
        logger.info("controller");
        return productService.getProductById(id);

    }
    /*-----------------------------------------------------------------------------------------------------------------------------------------------------------*/


    //                                                                       Delete Product By Id


    /*-----------------------------------------------------------------------------------------------------------------------------------------------------------*/
//
    @DeleteMapping("/{id}")
    public GenericProductDto deleteProductById(@PathVariable("id") Long id) {


        return productService.deleteProduct(id);


    }


//        // task 2
//
//    }
    /*-----------------------------------------------------------------------------------------------------------------------------------------------------------*/


    //                                                                        Create Product


    /*-----------------------------------------------------------------------------------------------------------------------------------------------------------*/
//    @PostMapping
//    public GenericProductDto createProduct(@RequestBody GenericProductDto product) {
//
//        logger.info(product.getTitle());
//
//        return productService.createProduct(product);
//
//        //return "Created new Prodct: "+ UUID.randomUUID();
//
//
//
//    }
    /*-----------------------------------------------------------------------------------------------------------------------------------------------------------*/


    //                                                                    Update Product By Id





    /*-----------------------------------------------------------------------------------------------------------------------------------------------------------*/


//    @PutMapping("/{id}")
//    public GenericProductDto updateProductById(@PathVariable Long id) {
//
//
//        return productService.updateProductById(id);
//
//                 // task 1
//    }
    /*-----------------------------------------------------------------------------------------------------------------------------------------------------------*/

}


