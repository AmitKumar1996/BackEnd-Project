package dev.amit.ProductService.services;

import dev.amit.ProductService.dtos.FakeStoreProductDtos;
import dev.amit.ProductService.dtos.GenericProductDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service("fakestoreproductservice")
public class FakeStoreProductService implements ProductService {


    //                                   API URL


    /*-----------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    private RestTemplateBuilder restTemplateBuilder;
    private String getProductRequstUrl = "https://fakestoreapi.com/products/{id}";
    private String ProductResquestBaseUrl = "https://fakestoreapi.com/products";
    //   private String getAllProductUrl = "https://fakestoreapi.com/products";
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
        ResponseEntity<GenericProductDto> response = restTemplate.postForEntity(ProductResquestBaseUrl,
                product,
                GenericProductDto.class);

        return response.getBody();


    }

    @Override
    public GenericProductDto updateProductById(Long id) {
        return null;
    }
    /*-----------------------------------------------------------------------------------------------------------------------------------------------------------------*/


    //                                          Get All Product By Id


    /*-----------------------------------------------------------------------------------------------------------------------------------------------------------------*/

    @Override
    public List<GenericProductDto> getAllProducts() {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<FakeStoreProductDtos[]> response =
                restTemplate.getForEntity(ProductResquestBaseUrl,  FakeStoreProductDtos[].class);
        List<GenericProductDto> answer = new ArrayList<>();
        for (FakeStoreProductDtos fakeStoreProductDtos : response.getBody()) {
            GenericProductDto product = new GenericProductDto();  // I converted dto that my client needed

            product.setImage(fakeStoreProductDtos.getImage());
            product.setDescription(fakeStoreProductDtos.getDescription());
            product.setTitle(fakeStoreProductDtos.getTitle());
            product.setPrice(fakeStoreProductDtos.getPrice());
            product.setCategory(fakeStoreProductDtos.getCategory());
            answer.add(product);
        }
        return answer;

    }


//    @Override
//    public List<GenericProductDto> getAllProduct() {
//        RestTemplate restTemplate = restTemplateBuilder.build();
//
//        // Fetch the list of FakeStoreProductDtos using ParameterizedTypeReference
//        ResponseEntity<List<FakeStoreProductDtos>> response = restTemplate.exchange(
//                getAllProductUrl,
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<>() {}
//        );
//
//        // Extract the body from the response
//        List<FakeStoreProductDtos> body = response.getBody();
//
//        // Map the list of FakeStoreProductDtos to a list of GenericProductDto
//        if (body != null) {
//            return body.stream()
//                    .map(dto -> {
//                        GenericProductDto product = new GenericProductDto();
//                        product.setId(dto.getId());
//                        product.setTitle(dto.getTitle());
//                        product.setPrice(dto.getPrice());
//                        product.setDescription(dto.getDescription());
//                        product.setImage(dto.getImage());
//                        return product;
//                    })
//                    .collect(Collectors.toList());
//        }
//
//        // Return an empty list if the body is null
//        return List.of();
//    }

    /*-----------------------------------------------------------------------------------------------------------------------------------------------------------------*/


    //                                               Delete Product By Id


    /*-----------------------------------------------------------------------------------------------------------------------------------------------------------------*/

//    @Override
//    public GenericProductDto deleteProductById(Long id) {
//        return deleteProductById(fakeStoryProductServiceClient.deleteProduct(id));
//    }
//
//    @Override
//    public GenericProductDto updateProductById(Long id) {
//        return null;
//    }
//
//    @Override
//    public GenericProductDto deleteProduct(Long id) {
//        return convertFakeStoreProductIntoGenericProduct(fakeStoryProductServiceClient.deleteProduct(id));
//    }


//    @Override
//    public GenericProductDto deleteProductById(Long id) {
//
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<FakeStoreProductDtos> response = restTemplate.getForEntity(deleteAllProductUrl, FakeStoreProductDtos.class, id);
//        FakeStoreProductDtos fakeStoreProductDtos = response.getBody();
//        GenericProductDto product = new GenericProductDto();
//        product.setImage(fakeStoreProductDtos.getImage());
//
//        return product;
//    }

    /*-----------------------------------------------------------------------------------------------------------------------------------------------------------------*/


    //                                  Update Product By Id


    /*-----------------------------------------------------------------------------------------------------------------------------------------------------------------*/


//    @PostMapping("/{id}")
//    @Override
//    public GenericProductDto updateProductById(@PathVariable Long id) {
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<FakeStoreProductDtos> response = restTemplate.getForEntity(updateProductByIdUrl, FakeStoreProductDtos.class, id);
//        GenericProductDto product = new GenericProductDto();
//        product.setImage();
//
//        return product;
//    }



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

//    @Override
//    public GenericProductDto deleteProductById() {
//        return null;
//    }
    /*-----------------------------------------------------------------------------------------------------------------------------------------------------------------*/



}
