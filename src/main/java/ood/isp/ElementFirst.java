package ood.isp;

import java.util.ArrayList;
import java.util.List;

public class ElementFirst implements Element {

    private String name;
    private List<Element> list = new ArrayList<>();

    public ElementFirst(String name) {
        this.name = name;
    }

    public List<Element> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "ElementFirst{" + "name='" + name + '\'' + '}';
    }

    public void add(Element element) {
        list.add(element);
    }

    @Override
    public void print() {
        System.out.println(name);
        for (Element e : list) {
            e.print();
        }
    }

    @Override
    public void run() {

    }
}
