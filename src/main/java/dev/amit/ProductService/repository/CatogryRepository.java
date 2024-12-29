package dev.amit.ProductService.repository;

import dev.amit.ProductService.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CatogryRepository extends JpaRepository <Category, UUID>{


    // Optional<Category>: The method returns an Optional object wrapping a Category. This is useful for handling cases where the requested entity might not exist in the database.
    @Override
    Optional<Category> findById(UUID uuid);
}
