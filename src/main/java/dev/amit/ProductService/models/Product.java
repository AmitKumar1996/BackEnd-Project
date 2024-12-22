package dev.amit.ProductService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Entity





public class Product extends  BaseModel{


    private String title;
    private String description;
    private String image;
    //           P : C
    // => L to R 1 : 1
    // => R to  L m : 1
    // => Ans m : 1
    @ManyToOne
    private Category category;
    private double price;

    public Product(String title, String description, String image, Category category, double price) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.category = category;
        this.price = price;
    }
    public Product() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", category=" + category +
                ", price=" + price +
                '}';
    }
}
