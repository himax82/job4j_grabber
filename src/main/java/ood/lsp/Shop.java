package ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Storage {

    private List<Products> list = new ArrayList<>();

    public List<Products> getList() {
        return list;
    }

    public void setList(List<Products> list) {
        this.list = list;
    }

    @Override
    public void add(Products products) {
        double coef = ShelfLife.daysCoef(products.getExpiryDate(), products.getCreateDate());
        if (coef >= 0.25 && coef < 0.75) {
            list.add(products);
        } else if (coef >= 0.75 && coef < 1) {
            products.setPrice(products.getPrice() * products.getDiscount());
            list.add(products);
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Products p : list) {
            s.append(p.toString());
        }
        return "Shop{" + "list=" + s + '}';
    }
}
