package ood.lsp;

import java.time.LocalDate;
import java.util.Calendar;

public class Fish implements Products {

    private String fishName;
    private LocalDate expiryDate;
    private LocalDate dateOfCatch;
    private double price;
    private double discount;

    public Fish(String fishName, LocalDate expiryDate, LocalDate dateOfCatch, double price, double discount) {
        this.fishName = fishName;
        this.expiryDate = expiryDate;
        this.dateOfCatch = dateOfCatch;
        this.price = price;
        this.discount = discount;
    }

    public String getFishName() {
        return fishName;
    }

    public void setFishName(String fishName) {
        this.fishName = fishName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public LocalDate getCreateDate() {
        return dateOfCatch;
    }

    public void setDateOfCatch(LocalDate dateOfCatch) {
        this.dateOfCatch = dateOfCatch;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
