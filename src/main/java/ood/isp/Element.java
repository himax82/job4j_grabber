package ood.isp;

import java.util.List;

public interface Element {

    void print();
    void run();
    void add(Element element);
    List<Element> getList();
}
