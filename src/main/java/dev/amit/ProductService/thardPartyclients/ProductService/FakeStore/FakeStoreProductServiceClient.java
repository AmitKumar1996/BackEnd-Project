package dev.amit.ProductService.thardPartyclients.ProductService.FakeStore;

import dev.amit.ProductService.dtos.GenericProductDto;
import dev.amit.ProductService.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * Wrapper over FakeStore API
 */
@Service
public class FakeStoreProductServiceClient {


//    private GenericProductDto ConvertFakeStoreProductIntoGenricProduct(FakeStoreProductDtos fakeStoreProductDtos) {
//
//        GenericProductDto product = new GenericProductDto();
//        product.setId(fakeStoreProductDtos.getId());
//        product.setImage(fakeStoreProductDtos.getImage());
//        product.setDescription(fakeStoreProductDtos.getDescription());
//        product.setTitle(fakeStoreProductDtos.getTitle());
//        product.setPrice(fakeStoreProductDtos.getPrice());
//        product.setCategory(fakeStoreProductDtos.getCategory());
//
//
//        return product;
//
//    }




    public FakeStoreProductServiceClient(RestTemplateBuilder restTemplateBuilder) {

        this.restTemplateBuilder = restTemplateBuilder;
    }


    //                                   API URL


    /*-----------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    private RestTemplateBuilder restTemplateBuilder;
  //  private String getProductRequstUrl = "https://fakestoreapi.com/products/{id}";
  //  private String ProductResquestBaseUrl = "https://fakestoreapi.com/products";
    //   private String getAllProductUrl = "https://fakestoreapi.com/products";
    private String deleteAllProductUrl = "https://fakestoreapi.com/products/{id}";
    private String updateProductByIdUrl = "https://fakestoreapi.com/products/{id}";
    @Value("${fakestore.api.url}")
    private String fakestoreApiUrl;

    @Value("${fakestore.api.paths.product}")
    private String fakeStoreProductApi;


    private String getProductRequstUrl = "https://fakestoreapi.com/products/{id}";
    private String ProductResquestBaseUrl = "https://fakestoreapi.com/products";



    /*-----------------------------------------------------------------------------------------------------------------------------------------------------------------*/










    public FakeStoreProductDtos createProduct(GenericProductDto product) {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDtos> response = restTemplate.postForEntity(ProductResquestBaseUrl,
                product,
                FakeStoreProductDtos.class);

        return response.getBody();


    }

    public GenericProductDto updateProductById(Long id) {

  //      @Override
//    public GenericProductDto updateProductById(Long id, GenericProductDto updatedProduct) {
//        // Build RestTemplate from RestTemplateBuilder
//        RestTemplate restTemplate = restTemplateBuilder.build();
//
//        // Fetch the existing product details from the external API
//        ResponseEntity<FakeStoreProductDtos> response = restTemplate.getForEntity(updateProductByIdUrl, FakeStoreProductDtos.class, id);
//
//        // Extract the product from the response
//        FakeStoreProductDtos existingProduct = response.getBody();
//
//        // Ensure that the product exists
//        if (existingProduct == null) {
//            return null; // Return null, no exception handling as per the request
//        }
//
//        // Map the incoming updatedProduct to the FakeStoreProductDtos for the external API
//        existingProduct.setTitle(updatedProduct.getTitle());
//        existingProduct.setPrice(updatedProduct.getPrice());
//        existingProduct.setDescription(updatedProduct.getDescription());
//        existingProduct.setImage(updatedProduct.getImage());
//
//        // Send the updated product back to the external API
//        HttpEntity<FakeStoreProductDtos> requestEntity = new HttpEntity<>(existingProduct);
//        ResponseEntity<FakeStoreProductDtos> updatedResponse = restTemplate.exchange(
//                updateProductByIdUrl,
//                HttpMethod.PUT,
//                requestEntity,
//                FakeStoreProductDtos.class,
//                id
//        );
//
//        // Extract the updated product from the response
//        FakeStoreProductDtos updatedProductResponse = updatedResponse.getBody();
//
//        // Map the updated product to GenericProductDto
//        GenericProductDto product = new GenericProductDto();
//        product.setId(updatedProductResponse.getId());
//        product.setTitle(updatedProductResponse.getTitle());
//        product.setPrice(updatedProductResponse.getPrice());
//        product.setDescription(updatedProductResponse.getDescription());
//        product.setImage(updatedProductResponse.getImage());
//
//        return product;
        return null;
    }








    public FakeStoreProductDtos getProductById(Long id) throws NotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDtos> response =
                restTemplate.getForEntity(getProductRequstUrl, FakeStoreProductDtos.class, id);

        System.out.println("*******");
        FakeStoreProductDtos fakeStoreProductDtos = response.getBody();

        //    System.out.println("hhhh" + fakeStoreProductDtos.getId());


        if (fakeStoreProductDtos == null) {

            System.out.println("Exception");
            throw new NotFoundException("Product with id: " + id + " doesn't exist.");

        }
            return  fakeStoreProductDtos;
    }










    public List<FakeStoreProductDtos> getAllProducts() {

RestTemplate restTemplate =restTemplateBuilder.build();

            ResponseEntity<FakeStoreProductDtos[]> response =
                    restTemplate.getForEntity(ProductResquestBaseUrl,  FakeStoreProductDtos[].class);
            List<GenericProductDto> answer = new ArrayList<>();

            return Arrays.stream(response.getBody()).toList();




        }







    public FakeStoreProductDtos deleteProduct(Long id) {

        RestTemplate restTemplate = restTemplateBuilder.build();


        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDtos.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDtos>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDtos.class);
        ResponseEntity<FakeStoreProductDtos> responce = restTemplate.execute(getProductRequstUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);




        return responce.getBody();




    }
}
