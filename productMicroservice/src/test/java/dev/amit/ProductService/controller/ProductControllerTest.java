package dev.amit.ProductService.controller;

import dev.amit.ProductService.controllers.ProductController;
import dev.amit.ProductService.dtos.GenericProductDto;
import dev.amit.ProductService.exceptions.NotFoundException;
import dev.amit.ProductService.services.FakeStoreProductService;
import dev.amit.ProductService.services.ProductService;
import dev.amit.ProductService.thardPartyclients.ProductService.FakeStore.FakeStoreProductServiceClient;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductControllerTest {


    @Autowired
   private FakeStoreProductServiceClient fakeStoreProductServiceClient;
    //assertNull(fakeStoreProductServiceClient.getProductById(101l));

    @Autowired
    private ProductController productController;

    @MockitoBean
    private ProductService productService;

    @Autowired
    private FakeStoreProductService fakeStoreProductService;

    @Disabled
    @Test
   @DisplayName("returnsNullWhenProductDoesNotExist")
    void returnsNullWhenProductDoesNotExist() throws NotFoundException {


      //   when(productService.getProductById(any(Long.class))).thenCallRealMethod();
        when(productService.getProductById(121L)).thenReturn(null);

        System.out.println("This is test case");
        GenericProductDto genericProductDto = productController.getProductById(121L);





        assertNull(genericProductDto);

    }
    @Disabled
    @Test
    @DisplayName("throwExceptionWhenProductDoesnotExist")
    void throwExceptionWhenProductDoesnotExist() throws NotFoundException {
        when( productService.getProductById(any(Long.class))

        ).thenReturn((null));


        assertThrows(NotFoundException.class, ()->productController.getProductById(123L));
    }


    @Disabled
    @Test
    @DisplayName("returnsProductWhenProductExist")
    void returnProductWhenProductExist() throws NotFoundException {

        GenericProductDto genericProductDto = new GenericProductDto();



        when( productService.getProductById(any(Long.class))

        ).thenReturn((genericProductDto));


        assertEquals(genericProductDto, productController.getProductById((123L)));

    //    assertThrows(NotFoundException.class, ()->productController.getProductById(123L));
    }



   @Disabled("NOt uses full")
    @Test
    void shouldReturnTitleAmitWithProductID1() throws NotFoundException {
        GenericProductDto genericProductDto = new  GenericProductDto();

        genericProductDto.setTitle("Amit");

      when(productService.getProductById(1L)).thenReturn(genericProductDto);

      GenericProductDto genericProductDto1 = productController.getProductById(1L);

      assertEquals("Amit", genericProductDto1.getTitle(), "Title is not matching");

    }





    @Disabled
    @Test
    @DisplayName("Test getProductById throws NotFoundException when product is not found")
    void testGetProductByIdNotFound() {
        assertThrows(NotFoundException.class, () -> fakeStoreProductServiceClient.getProductById(101L));

    }









        @Test
    @DisplayName("1+ 1 equals 2")
    void testOnePlusOneTrue(){

     //   System.out.println("It is True");

        assertEquals (2, 1+1, " one plus is not comming to be");



    }
    @Test
    @DisplayName("testAdditionShouldBeCorrect")
    void testAdditionShouldBeCorrect(){

        assertTrue(-1 + -1 == -2, " adding 2 -ve is not correct");



        assertTrue(-1 + 0 == -1, " adding 1 + 0 is not correct " );

        assertTrue(0+ 0 == 0, " adding 1 + 0 is not");

        assertTrue(0 +-1 == -1,
                " adding 0 -ve is not correct"

        );

        assertFalse(-1 + 1 == 1, " adding 1 + 0 is not correct");
       // assertEquals(1 + 1 == 2, " adding 1 + 1 is not correct");
    }

    // Assertion Framework
    //--> allows you to make assertion
    // --> allows you to make check






}
