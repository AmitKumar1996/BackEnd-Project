package dev.amit.ProductService.services;

import dev.amit.ProductService.models.Category;

import java.util.List;

public interface CategoryService {


     Category getCategory(String uuid);



      List<String> getProductTitles( List<String> Categoryuuids);

}
