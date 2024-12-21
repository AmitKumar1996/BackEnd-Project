package dev.amit.ProductService.inheritanceDemo.mapSuperClass;

import jakarta.persistence.Entity;

@Entity(name = "ms_ta")
public class TA extends User {

    private double averageRating;

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }
}
