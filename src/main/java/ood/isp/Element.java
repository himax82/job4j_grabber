package ood.isp;

import java.util.List;

public interface Element {

    void add(Element element);
    List<Element> getList();
    Element search(String name);
    Action getAction();

}
