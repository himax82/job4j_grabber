package ood.lsp;

import java.time.LocalDate;

public interface Products {

    LocalDate getCreateDate();
    LocalDate getExpiryDate();
    double getPrice();
    void setPrice(double price);
    double getDiscount();

}
