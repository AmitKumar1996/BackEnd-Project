package dev.amit.ProductService.dtos;

import dev.amit.ProductService.models.Price;

public class ProductDto {


    private String title;
    private String description;
    private String image;


    private Price price;

    public ProductDto() {
        this.title = title;
        this.description = description;
        this.image = image;
        this.price = price;
    }

//    public ProductDto(String title, String description, String image, Price price) {
//        this.title = title;
//        this.description = description;
//        this.image = image;
//        this.price = price;
//    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public Price getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPrice(Price price) {

    }


}
