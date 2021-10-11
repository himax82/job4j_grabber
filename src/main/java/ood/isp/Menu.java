package ood.isp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    List<Element> list;

    public Menu(List<Element> list) {
        this.list = list;
    }

    public void init() {
        for (Element e : list) {
            System.out.println(e);
        }
    }

    public Element search(String name) {
        Element result;
            for (Element e : list) {
                result = e.search(name);
                if (result != null) {
                    return result;
                }
            }
        return null;
    }

    public void addChild(String parentName, String childName, Action action) {
        Element elementParent = search(parentName);
        elementParent.add(new ElementFirst(childName, action));
    }

    public Action findAction(String name) {
        return search(name).getAction();
    }

    public static void main(String[] args) {
        Menu menu = new Menu(new ArrayList<>());
        Element element1 = new ElementFirst("Задача 1", new ActionFirst());
        Element element2 = new ElementFirst("Задача 2", new ActionFirst());
        menu.list.add(element1);
        menu.list.add(element2);
        menu.addChild("Задача 1", "Задача 1.1", new ActionFirst());
        menu.addChild("Задача 1.1", "Задача 1.1.1", new ActionFirst());
        menu.addChild("Задача 1.1", "Задача 1.1.2", new ActionFirst());
        menu.addChild("Задача 1", "Задача 1.2", new ActionFirst());
        menu.addChild("Задача 1", "Задача 1.3", new ActionFirst());
        menu.init();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название пункта который хотите запустить: ");
        String s = scanner.nextLine();
        menu.findAction(s).run();
    }
}
