package ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Storage {

   private List<Products> list = new ArrayList<>();

    public List<Products> getList() {
        return list;
    }

    public void setList(List<Products> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Products p : list) {
            s.append(p.toString());
        }
        return "Trash{" + "list=" + s + '}';
    }

    @Override
    public void add(Products products) {
        if (ShelfLife.daysCoef(products.getExpiryDate(), products.getCreateDate()) >= 1) {
            list.add(products);
        }
    }

}
