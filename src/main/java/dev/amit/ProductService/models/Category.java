package dev.amit.ProductService.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
@Entity

public class Category extends  BaseModel {
   @Column
    private String name;


    @OneToMany(mappedBy = "category")
    private List<Product> product;

    // this is the same relation being maped by the other(product) class


}
// class group{
// m:m
//   List<User> memeber;
//   m:m
//   List<User> admins;



//   1----->1
//   m------>1
//   ----------
//     m  :  1
//   User creator;
//
// }
