package dev.amit.ProductService.repository;

import dev.amit.ProductService.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {


    List<Product> findByTitleEquals(String title);


    List<Product> findByTitleEqualsAndPrice_Price(String title, Double price);


    List<Product> findByPrice_Currency(String currency);


    List<Product> findAllByPriceCurrency(String currency);


    List<Product> findByTitleAndDescription(String title, String description);








}
