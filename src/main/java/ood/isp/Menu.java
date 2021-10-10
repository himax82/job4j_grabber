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
            e.print();
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu(new ArrayList<>());
        Element element1 = new ElementFirst("Задача 1");
        Element element2 = new ElementFirst("Задача 2");
        Element element11 = new ElementFirst("Задача 1.1");
        element1.add(element11);
        Element element111 = new ElementFirst("Задача 1.1.1");
        element11.add(element111);
        Element element112 = new ElementFirst("Задача 1.1.2");
        element11.add(element112);
        Element element12 = new ElementFirst("Задача 1.2");
        element1.add(element12);
        Element element13 = new ElementFirst("Задача 1.3");
        element1.add(element13);
        menu.list.add(element1);
        menu.list.add(element2);
        menu.init();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер пункта: ");
        String s = scanner.nextLine();
        String[] ar = s.split("\\.");
        List<Element> e = menu.list;
        Element element = null;
        for (String st : ar) {
             element = e.get(Integer.parseInt(st) - 1);
             e = element.getList();
        }
        element.run();
    }
}
