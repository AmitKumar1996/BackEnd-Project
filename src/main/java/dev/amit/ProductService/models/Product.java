package dev.amit.ProductService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Entity
@Builder
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
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

}
