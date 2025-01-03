package dev.amit.ProductService.repository;

import dev.amit.ProductService.models.Category;
import dev.amit.ProductService.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {


    //  List<Product> findByTitleEquals(String title);


    List<Product> findByTitleEqualsAndPrice_Price(String title, Double price);


    List<Product> findByPrice_Currency(String currency);


    List<Product> findAllByPriceCurrency(String currency);


    List<Product> findByTitleAndDescription(String title, String description);


    long countAllByPrice_Currency(String currency);

    List<Product> findDistinctByPriceCurrency(String currency);

// List<Product> products= findAllByCategoryIn(List<Category> categories);



//--------------------------------------------------------Native MySQL Query-------------------------------------------------------------------------------------------------------------



    @Query(value = CustomQuries.FIND_ALL_PRODUCTS_BY_TITLE, nativeQuery = true)
    List<Product> findBytTitle(String amit);



// ---------------------------------------------------------Hibernate Query Language----------------------------------------------------------------
    // when function is complex thenyou shoulduse the HiberNet query    language
/*
    @Query("select Product From Product  where Product.price.currency = :currency and Product.title = :amit")
    List<Product> hiberNetQueryLanguage(String amit, String currency);

 */

}
