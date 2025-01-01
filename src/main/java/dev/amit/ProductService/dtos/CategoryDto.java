package dev.amit.ProductService.dtos;

import dev.amit.ProductService.models.Product;

import java.util.List;

public class CategoryDto {
    private String name;
    private List<Product> products;

    public String getName() {
        return name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
