package dev.amit.ProductService.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.amit.ProductService.controllers.ProductController;
import dev.amit.ProductService.dtos.GenericProductDto;
import dev.amit.ProductService.services.ProductService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// not initialize nay unnamed bean
// only  initialize  dependency that can


@Disabled
@WebMvcTest(ProductController.class)
public class ProductControllerWebMVCTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProductService productService;

    @Autowired
    private ObjectMapper objectMapper;


    @Disabled
    @Test
    @DisplayName("getAllProductsReturnsEmptyListWhenNoProduct")
    void getAllProductsReturnsEmptyListWhenNoProduct() throws Exception {
        when(productService.getAllProducts())
      .thenReturn(new ArrayList<>());
        mockMvc.perform(get("/products"))
                .andExpect(status().is(200))
                .andExpect((ResultMatcher) content().string("[]"));


    }



    @Disabled

    @Test
    void returnListOfProductsWhenProductsExist() throws Exception {

        ArrayList<GenericProductDto> products= new ArrayList<>();

        products.add(new GenericProductDto());
        products.add(new GenericProductDto());
        products.add(new GenericProductDto());

        when(
                productService.getAllProducts()
        ).thenReturn(
                products
        );
        mockMvc.perform(
                get("/products")
        ).andExpect(
                status().is(200)
        ).andExpect(
                (ResultMatcher) content().string(objectMapper.writeValueAsString(products))
        );


    }

    @Disabled
    @Test
    void createProductShouldCreateANewProduct() throws Exception {
        GenericProductDto  productToCreate = new GenericProductDto();

        productToCreate.setTitle("iphone 15 Pro Max");
        productToCreate.setImage("Some Images");
        productToCreate.setCategory("model phone");
        productToCreate.setDescription("This is new iPhone 15 Pro Max");

        GenericProductDto expectedProduct = new GenericProductDto();
        expectedProduct.setId(1001L);
        expectedProduct.setTitle("iphone 15 Pro Max");
        expectedProduct.setImage("Some Images");
        expectedProduct.setCategory("model phone");
        expectedProduct.setDescription("This is new iPhone 15 Pro Max");


        when(
                productService.createProduct(any())
        ).thenReturn(expectedProduct);


        mockMvc.perform(
                post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productToCreate))
        ).andExpect(
                (ResultMatcher) content().string(objectMapper.writeValueAsString(expectedProduct))
        );
    }
}



//package dev.amit.ProductService.controller;
//
//import dev.amit.ProductService.controllers.ProductController;
//import dev.amit.ProductService.services.ProductService;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.test.context.bean.override.mockito.MockitoBean;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultMatcher;
//
//import java.util.ArrayList;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(ProductController.class)
//public class ProductControllerWebMVCTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockitoBean
//    private ProductService productService;
//
//    @Test
//    @DisplayName("getAllProductsReturnsEmptyListWhenNoProduct")
//    void getAllProductsReturnsEmptyListWhenNoProduct() throws Exception {
//        when(productService.getAllProducts())
//                .thenReturn(new ArrayList<>());
//
//        mockMvc.perform(get("/products"))
//                .andExpect(status().is(200))
//                .andExpect(content().json("[]"));  // Corrected line
//    }
//}






//package dev.amit.ProductService.controller;
//
//import dev.amit.ProductService.controllers.ProductController;
//import dev.amit.ProductService.services.ProductService;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.test.context.bean.override.mockito.MockitoBean;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultMatcher;
//
//import java.util.ArrayList;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//
//@WebMvcTest(ProductController.class)
//public class ProductControllerWebMVCTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockitoBean
//    private ProductService productService;
//
//    @Test
//    @DisplayName("getAllProductsReturnsEmptyListWhenNoProduct")
//    void getAllProductsReturnsEmptyListWhenNoProduct() throws Exception {
//        // Mocking the service layer to return an empty list
//        when(productService.getAllProducts()).thenReturn(new ArrayList<>());
//
//        // Performing the GET request and checking the status and content
//        mockMvc.perform(get("/products"))
//                .andExpect(status().isOk())  // Expecting 200 OK status
//                .andExpect(content().string("[]"));  // Expecting an empty list as the response
//    }
//}

