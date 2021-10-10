package ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Storage {

    private List<Products> list = new ArrayList<>();

    public List<Products> getList() {
        return list;
    }

    public void setList(List<Products> list) {
        this.list = list;
    }

    @Override
    public void add(Products products) {
        list.add(products);
    }
}
