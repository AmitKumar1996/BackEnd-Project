package dev.amit.ProductService.repository;

public interface CustomQuries {
    String FIND_ALL_PRODUCTS_BY_TITLE = "select * from product join product_orders on product.id = product_orders.product_id where title = :amit ";
}
