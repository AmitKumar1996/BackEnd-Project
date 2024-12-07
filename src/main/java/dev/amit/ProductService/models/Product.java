package dev.amit.ProductService.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends  BaseModel{
    private String title;
    private String description;
    private String image;
    private Category category;
    private double price;

}
