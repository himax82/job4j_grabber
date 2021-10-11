package ood.isp;

import java.util.ArrayList;
import java.util.List;

public class ElementFirst implements Element {

    private String name;
    private List<Element> list = new ArrayList<>();
    private Action action;

    public ElementFirst(String name, Action action) {
        this.name = name;
        this.action = action;
    }

    public List<Element> getList() {
        return list;
    }

    public Element search(String name) {
        Element result;
        if (name.equals(this.name)) {
            return this;
        } else {
            for (Element e : list) {
                result = e.search(name);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }

    public Action getAction() {
        return action;
    }

    public void add(Element element) {
        list.add(element);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name);
        for (Element e : list) {
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(e.toString());
        }
        return stringBuilder.toString();
    }
}
