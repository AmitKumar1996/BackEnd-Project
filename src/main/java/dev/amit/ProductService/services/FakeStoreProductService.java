package dev.amit.ProductService.services;

import dev.amit.ProductService.dtos.GenericProductDto;
import dev.amit.ProductService.exceptions.NotFoundException;
import dev.amit.ProductService.thardPartyclients.ProductService.FakeStore.FakeStoreProductDtos;
import dev.amit.ProductService.thardPartyclients.ProductService.FakeStore.FakeStoreProductServiceClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Primary
@Service("fakestoreproductservice")
public class FakeStoreProductService implements ProductService {


    //                                   API URL


    /*-----------------------------------------------------------------------------------------------------------------------------------------------------------------*/
//    private RestTemplateBuilder restTemplateBuilder;
//    private String getProductRequstUrl = "https://fakestoreapi.com/products/{id}";
//    private String ProductResquestBaseUrl = "https://fakestoreapi.com/products";
//    //   private String getAllProductUrl = "https://fakestoreapi.com/products";
//    private String deleteAllProductUrl = "https://fakestoreapi.com/products/{id}";
//    private String updateProductByIdUrl = "https://fakestoreapi.com/products/{id}";

    // @Autowired.    es ka use nhi hai ab new SpringBoot version me
    private final FakeStoreProductServiceClient fakeStoreProductServiceClient;

    /*-----------------------------------------------------------------------------------------------------------------------------------------------------------------*/


//                                              Constructor


    /*-----------------------------------------------------------------------------------------------------------------------------------------------------------------*/
//    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder) {
//
//        this.restTemplateBuilder = restTemplateBuilder;
//    }



    public FakeStoreProductService( FakeStoreProductServiceClient fakeStoreProductServiceClient) {

        this.fakeStoreProductServiceClient=fakeStoreProductServiceClient;
    }




    private GenericProductDto ConvertFakeStoreProductIntoGenricProduct(FakeStoreProductDtos fakeStoreProductDtos) {


        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        GenericProductDto product = new GenericProductDto();
        product.setId(fakeStoreProductDtos.getId());
        product.setImage(fakeStoreProductDtos.getImage());
        product.setDescription(fakeStoreProductDtos.getDescription());
        product.setTitle(fakeStoreProductDtos.getTitle());
        product.setPrice(fakeStoreProductDtos.getPrice());
        product.setCategory(fakeStoreProductDtos.getCategory());

        System.out.println("*I****************************" + product.getPrice());
        return product;

    }





    /*-----------------------------------------------------------------------------------------------------------------------------------------------------------------*/


    //                                         Create Product By Id


    /*-----------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<GenericProductDto> response = restTemplate.postForEntity(ProductResquestBaseUrl,
//                product,
//                GenericProductDto.class);
//
//        return response.getBody();


        return  ConvertFakeStoreProductIntoGenricProduct(
                fakeStoreProductServiceClient.createProduct(product));


    }

    @Override
    public GenericProductDto updateProductById(Long id) {
        return null;
    }

    // @Override
//    public GenericProductDto updateProductById(Long id) {
//        return null;
//    }

//    @Override
//    public GenericProductDto updateProductById(Long id) {
//        return null;
//    }
    /*-----------------------------------------------------------------------------------------------------------------------------------------------------------------*/


    //                                          Get All Product By Id


    /*-----------------------------------------------------------------------------------------------------------------------------------------------------------------*/


// Method 1


    @Override
    public List<GenericProductDto> getAllProducts() {
//
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<FakeStoreProductDtos[]> response =
//                restTemplate.getForEntity(ProductResquestBaseUrl,  FakeStoreProductDtos[].class);
//        List<GenericProductDto> answer = new ArrayList<>();
//        for (FakeStoreProductDtos fakeStoreProductDtos : response.getBody()) {
//            GenericProductDto product = new GenericProductDto();  // I converted dto that my client needed
//
//
//            answer.add(ConvertFakeStoreProductIntoGenricProduct(fakeStoreProductDtos));
//
//        }
//        return answer;


        List<GenericProductDto> genericProductDtos=new ArrayList<>();
        for(FakeStoreProductDtos fakeStoreProductDtos : fakeStoreProductServiceClient.getAllProducts()){
            genericProductDtos.add(ConvertFakeStoreProductIntoGenricProduct(fakeStoreProductDtos));
        }

        return genericProductDtos;

    }


    // Method 2


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

    @Override
    public GenericProductDto deleteProduct(Long id) {
//        RestTemplate restTemplate = restTemplateBuilder.build();
//
//
//        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDtos.class);
//        ResponseExtractor<ResponseEntity<FakeStoreProductDtos>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDtos.class);
//        ResponseEntity<FakeStoreProductDtos> responce = restTemplate.execute(getProductRequstUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);
//
//        FakeStoreProductDtos fakeStoreProductDtos = responce.getBody();
//
//
//        return ConvertFakeStoreProductIntoGenricProduct(fakeStoreProductDtos);


        return ConvertFakeStoreProductIntoGenricProduct( fakeStoreProductServiceClient.deleteProduct(id));


    }


//    @ExceptionHandler(NotFoundException.class)
//    private void handelNotFoundException() {
//        System.out.println("Not Found Exception happened");
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

//
//    @Override
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
//    }




//    @PostMapping("/{id}")
//    @Override
//    public GenericProductDto updateProductById(@PathVariable Long id) {
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<FakeStoreProductDtos> response = restTemplate.getForEntity(updateProductByIdUrl, FakeStoreProductDtos.class, id);
//        GenericProductDto product = new GenericProductDto();
//
//        return product;
//    }



    /*-----------------------------------------------------------------------------------------------------------------------------------------------------------------*/


    //                                            Get Product By Id


    /*-----------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundException {

//
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<FakeStoreProductDtos> response =
//                restTemplate.getForEntity(getProductRequstUrl, FakeStoreProductDtos.class, id);
//
//        System.out.println("*******");
//        FakeStoreProductDtos fakeStoreProductDtos = response.getBody();
//
//    //    System.out.println("hhhh" + fakeStoreProductDtos.getId());
//
//
//        if (fakeStoreProductDtos == null) {
//
//            System.out.println("Exception");
//            throw new NotFoundException("Product with id: " + id + " doesn't exist.");
//
//        }







//        GenericProductDto product = new GenericProductDto();  // I converted dto that my client needed
//
//       product.setImage(fakeStoreProductDtos.getImage());
//       product.setId(fakeStoreProductDtos.getId());
//        product.setDescription(fakeStoreProductDtos.getDescription());
//        product.setTitle(fakeStoreProductDtos.getTitle());
//        product.setPrice(fakeStoreProductDtos.getPrice());
//        product.setCategory(fakeStoreProductDtos.getCategory());

       // return ConvertFakeStoreProductIntoGenricProduct(fakeStoreProductDtos);

        System.out.println("I am in fakestoreProductServices***********************************************************###############___________" + id);
        System.out.println();

   return ConvertFakeStoreProductIntoGenricProduct( fakeStoreProductServiceClient.getProductById(id));
    }

    /*-----------------------------------------------------------------------------------------------------------------------------------------------------------------*/



}
