package dev.amit.ProductService.services;

import dev.amit.ProductService.dtos.FakeStoreProductDtos;
import dev.amit.ProductService.dtos.GenericProductDto;
import dev.amit.ProductService.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service("fakestoreproductservice")
public class FakeStoreProductService implements ProductService {


    //                                   API URL


    /*-----------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    private RestTemplateBuilder restTemplateBuilder;
    private String getProductRequstUrl = "https://fakestoreapi.com/products/{id}";
    private String createProductRequestUrl = "https://fakestoreapi.com/products";
    private String getAllProductUrl = "https://fakestoreapi.com/products";
    private String deleteAllProductUrl = "https://fakestoreapi.com/products/{id}";
    private String updateProductByIdUrl = "https://fakestoreapi.com/products/{id}";
    /*-----------------------------------------------------------------------------------------------------------------------------------------------------------------*/


//                                              Constructor


    /*-----------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder) {

        this.restTemplateBuilder = restTemplateBuilder;
    }
    /*-----------------------------------------------------------------------------------------------------------------------------------------------------------------*/


    //                                         Create Product By Id


    /*-----------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GenericProductDto> response = restTemplate.postForEntity(createProductRequestUrl,
                product,
                GenericProductDto.class);

        return response.getBody();


    }
    /*-----------------------------------------------------------------------------------------------------------------------------------------------------------------*/


    //                                          Get All Product By Id


    /*-----------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    @Override
    public List<Product> getAllProduct() {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDtos> response = restTemplate.getForEntity(getAllProductUrl, FakeStoreProductDtos.class);
        FakeStoreProductDtos fakeStoreProductDtos = response.getBody();

        GenericProductDto product = new GenericProductDto();

        product.setImage(fakeStoreProductDtos.getImage());
        product.setTitle(fakeStoreProductDtos.getTitle());
        product.setPrice(fakeStoreProductDtos.getPrice());
        product.setCategory(fakeStoreProductDtos.getCategory());
        product.setDescription(fakeStoreProductDtos.getDescription());

        return (List<Product>) product;


    }
    /*-----------------------------------------------------------------------------------------------------------------------------------------------------------------*/


    //                                               Delete Product By Id


    /*-----------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    @Override
    public GenericProductDto deleteProductById(Long id) {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDtos> response = restTemplate.getForEntity(deleteAllProductUrl, FakeStoreProductDtos.class, id);
        FakeStoreProductDtos fakeStoreProductDtos = response.getBody();
        GenericProductDto product = new GenericProductDto();
        product.setImage(fakeStoreProductDtos.getImage());

        return product;
    }

    /*-----------------------------------------------------------------------------------------------------------------------------------------------------------------*/


    //                                  Update Product By Id


    /*-----------------------------------------------------------------------------------------------------------------------------------------------------------------*/


    public GenericProductDto updateProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDtos> response = restTemplate.getForEntity(updateProductByIdUrl, FakeStoreProductDtos.class, id);


        return product;
    }



    /*-----------------------------------------------------------------------------------------------------------------------------------------------------------------*/


    //                                            Get Product By Id


    /*-----------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    @Override
    public GenericProductDto getProductById(Long id) {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDtos> response =
                restTemplate.getForEntity(getProductRequstUrl, FakeStoreProductDtos.class, id);
        //response.getStatusCode();

        System.out.println("*******");
        FakeStoreProductDtos fakeStoreProductDtos = response.getBody();

        System.out.println("hhhh" + fakeStoreProductDtos.getImage());

        GenericProductDto product = new GenericProductDto();  // I converted dto that my client needed

       product.setImage(fakeStoreProductDtos.getImage());
        product.setDescription(fakeStoreProductDtos.getDescription());
        product.setTitle(fakeStoreProductDtos.getTitle());
        product.setPrice(fakeStoreProductDtos.getPrice());
        product.setCategory(fakeStoreProductDtos.getCategory());

        return product;
    }
    /*-----------------------------------------------------------------------------------------------------------------------------------------------------------------*/



}
