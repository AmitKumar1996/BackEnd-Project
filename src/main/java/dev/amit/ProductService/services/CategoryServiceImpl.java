package dev.amit.ProductService.services;

import dev.amit.ProductService.models.Category;
import dev.amit.ProductService.models.Product;
import org.springframework.stereotype.Service;
import dev.amit.ProductService.models.CategoryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service

public class CetegoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CetegoryServiceImpl(CategoryRepository categoryRepository) {

        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category getCategory(String uuid) {


        Optional<Category> categoryOptional = categoryRepository.findById(UUID.fromString(uuid));
        if (categoryOptional.isEmpty()) {
            return null;
        }
        Category category = categoryOptional.get();
       List<Product> products = category.getProduct();
        return category;
    }

    public List<String> getProductTitle( List<String> Categoryuuids) {

        List<UUID> uuids=new ArrayList<>();

        for(String uuid:Categoryuuids){
            uuids.add(UUID.fromString(uuid));
        }

        List<Category> categories=categoryRepository.findAllById(uuids);

      List<String> titles= new ArrayList<>();
      categories.forEach(
              category -> {
                  category.getProduct().forEach(
                          product -> {
                              titles.add(product.getTitle());
                          }
                  );
              }
      );


        return titles;
    }



}
