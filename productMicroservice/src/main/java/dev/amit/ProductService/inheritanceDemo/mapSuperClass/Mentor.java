package dev.amit.ProductService.inheritanceDemo.mapSuperClass;

import jakarta.persistence.Entity;

@Entity(name = "ms_mentor")
public class Mentor extends User {

    private double averageRating;

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }
}
