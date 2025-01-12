package dev.amit.ProductService.thardPartyclients.ProductService.FakeStore;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class FakeStoreProductServiceClientTest {

    @Test
    void createProduct() {
    }

    @Test
    void updateProductById() {
    }

    @Test
    void testgetProductById() {




    }

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;



    // Integration Testing Example
    @Test
    @DisplayName("Integration Testing")
    void testNonExistingProductReturnsNull () {
//
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<FakeStoreProductDtos> response =
//                restTemplate.getForEntity(getProductRequstUrl, FakeStoreProductDtos.class, id);
//
//
//        FakeStoreProductDtos fakeStoreProductDtos = response.getBody();
//
//        assertNull(fakeStoreProductDtos);
    }

    @Test
    void getAllProducts() {
    }

    @Test
    void deleteProduct() {
    }
}