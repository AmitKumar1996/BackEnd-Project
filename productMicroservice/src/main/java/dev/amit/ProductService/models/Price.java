package dev.amit.ProductService.models;

import jakarta.persistence.Entity;

@Entity

public class Price extends  BaseModel{
    String currency;

    double price;


    public Price(String currency, double price) {
        this.currency = currency;
        this.price = price;
    }
    public Price() {

    }





    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
