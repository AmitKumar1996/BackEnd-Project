package dev.amit.ProductService.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Builder

@Entity

public class Category extends  BaseModel {
   @Column
    private String name;


    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    // @Fetch(FetchMode.JOIN) ---> N+1 DB calls
    // @Fetch(FetchMode.SELECT) --> N+1 DB calls
    //  @Fetch(FetchMode.SUBSELECT) -->(2 DB call only) fisrt Query will fetch all of the product and second query will fetch all of the products from all of the of the categories

    private List<Product> product = new ArrayList<>();

    public Category(String name, List<Product> product) {
        this.name = name;
        this.product = product;
    }


    public Category() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

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
