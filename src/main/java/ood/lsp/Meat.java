package ood.lsp;

import java.time.LocalDate;
import java.util.Calendar;

public class Meat implements Products {

    private String kindOfMeat;
    private LocalDate expiryDate;
    private LocalDate slaughterDate;
    private double price;
    private double discount;

    public Meat(String kindOfMeat, LocalDate expiryDate, LocalDate slaughterDate, double price, double discount) {
        this.kindOfMeat = kindOfMeat;
        this.expiryDate = expiryDate;
        this.slaughterDate = slaughterDate;
        this.price = price;
        this.discount = discount;
    }

    public String getKindOfMeat() {
        return kindOfMeat;
    }

    public void setKindOfMeat(String kindOfMeat) {
        this.kindOfMeat = kindOfMeat;
    }

    @Override
    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public LocalDate getCreateDate() {
        return slaughterDate;
    }

    public void setSlaughterDate(LocalDate slaughterDate) {
        this.slaughterDate = slaughterDate;
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

    @Override
    public String toString() {
        return "Meat{" + "kindOfMeat='" + kindOfMeat + '\''
                + ", expiryDate=" + expiryDate + ", slaughterDate="
                + slaughterDate + ", price=" + price
                + ", discount=" + discount + '}';
    }
}
