package dev.amit.ProductService.inheritanceDemo.joinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name = "jt_student")
@PrimaryKeyJoinColumn(name = "user_id")
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
