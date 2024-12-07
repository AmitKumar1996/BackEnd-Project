package dev.amit.ProductService.services;

import dev.amit.ProductService.dtos.FakeStoreProductDtos;
import dev.amit.ProductService.dtos.GenericProductDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service("fakestoreproductservice")
public class FakeStoreProductService implements ProductService {

    private RestTemplateBuilder restTemplateBuilder;
    private String getProductRequstUrl = "https://fakestoreapi.com/products/{id}";
    private String createProductRequestUrl = "https://fakestoreapi.com/products";

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder) {

        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GenericProductDto> response = restTemplate.postForEntity(createProductRequestUrl,
                product,
                GenericProductDto.class);

        return response.getBody();


    }

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
}
