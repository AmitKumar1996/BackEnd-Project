package dev.amit.ProductService.services;

import dev.amit.ProductService.models.Category;
import dev.amit.ProductService.models.CategoryRepository;
import dev.amit.ProductService.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service

public class CetogeryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CetogeryServiceImpl(CategoryRepository categoryRepository) {

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
}
