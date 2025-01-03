package dev.amit.ProductService.repository;

import dev.amit.ProductService.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CategryRepository extends JpaRepository <Category, UUID>{


    // Optional<Category>: The method returns an Optional object wrapping a Category. This is useful for handling cases where the requested entity might not exist in the database.
    Optional<Category> findById(UUID uuid);
    List<Category> findAllById(Iterable<UUID> uuids);
}
