package dev.amit.ProductService.inheritanceDemo.singelTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name = "st_student")
@DiscriminatorValue(value = "1")
public class Student extends User {

    private double psp;
    private double atandance;

    public double getPsp() {
        return psp;
    }

    public void setPsp(double psp) {
        this.psp = psp;
    }

    public double getAtandance() {
        return atandance;
    }

    public void setAtandance(double atandance) {
        this.atandance = atandance;
    }
}
