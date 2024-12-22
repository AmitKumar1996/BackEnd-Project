package dev.amit.ProductService.repository;

import dev.amit.ProductService.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CatogryRepository extends JpaRepository <Category, UUID>{

}
