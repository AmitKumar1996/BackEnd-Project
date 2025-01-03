package dev.amit.ProductService.controllers;

import dev.amit.ProductService.dtos.GetProductTitlesRequestDto;
import dev.amit.ProductService.dtos.ProductDto;
import dev.amit.ProductService.models.Product;
import dev.amit.ProductService.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{uuid}")
    public List<ProductDto> getCategory(@PathVariable("uuid") String uuid) {

        List<Product> products = categoryService.getCategory(uuid).getProduct();

        List<ProductDto> productDtos = new ArrayList<>();

        for (Product product : products) {
            ProductDto productDto = new ProductDto();
            productDto.setDescription(product.getDescription());
            productDto.setTitle(product.getTitle());
            productDto.setImage(product.getImage());
           productDto.setPrice(product.getPrice());
            productDtos.add(productDto);

        }

        return productDtos;

    }
    @GetMapping("/titles")
    public List<String> getProductTitles(@RequestBody GetProductTitlesRequestDto requestDto){
        List<String> uuids = requestDto.getUuids();
        return  categoryService.getProductTitles(uuids);
    }

}
