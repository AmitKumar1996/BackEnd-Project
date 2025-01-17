package dev.amit.ProductService.inheritanceDemo.joinedTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name = "jt_ta")
@DiscriminatorValue(value = "2")
@PrimaryKeyJoinColumn(name = "user_id")
public class TA extends User {

    private double averageRating;

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }
}
