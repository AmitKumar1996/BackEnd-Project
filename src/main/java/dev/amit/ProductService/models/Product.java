package dev.amit.ProductService.models;

import jakarta.persistence.*;
import lombok.Data;
import org.apache.logging.log4j.util.Lazy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity


@Data


public class Product extends  BaseModel{


    private String title;
    private String description;
    private String image;

//            TRICKS
    //           P : C
    // => L to R 1 : 1
    // => R to  L m : 1
    // => Ans m : 1


    // when you're trying to save a product if there is a category in it first save a category then save the product, if you not use cascade then you should get error message





    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "category")
    private Category category;


  @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
  @JoinColumn(unique = true)

  // someone trying to save there product do not save

    private Price price;


    //int n =   option + R
    // int n= 739;

//    public Price getPrice() {
//        return price;
//    }

    public void setPrice(Price price) {
        this.price = price; // Assign the parameter to the field
    }







    public Product(String title, String description, String image, Category category, Price price) {
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

    public Price getPrice() {
        return price;
    }
//    public void setPrice(Price price) {
//        this.price = price;
//    }

    public void setPrice() {
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


//    public Product(String title, String description, String image, Category category, double price) {
//        this.title = title;
//        this.description = description;
//        this.image = image;
//        this.category = category;
//        this.price = price;
//    }
//    public Product() {
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getImage() {
//        return image;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }
//
//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }

//    @Override
//    public String toString() {
//        return "Product{" +
//                "title='" + title + '\'' +
//                ", description='" + description + '\'' +
//                ", image='" + image + '\'' +
//                ", category=" + category +
//                ", price=" + price +
//                '}';
//    }
}
