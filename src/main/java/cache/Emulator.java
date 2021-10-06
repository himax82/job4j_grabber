package cache;

import java.util.Scanner;

public class Emulator {

        private static void showMenu() {
            String[] menu = {
                    "Задание кешируемой директории: ",
                    "Задание кешируемого файла: ",
                    "Чтение кешируемого файла: ",
                    "Выход из программы."
            };
            System.out.println("Меню:");
            for (int i = 0; i < menu.length; i++) {
                System.out.println(i + ". " + menu[i]);
            }
        }
    public static void init(Scanner scanner, DirFileCache dirFileCache) {
        boolean run = true;
        while (run) {
            showMenu();
            System.out.print("Выберете пункт: ");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                System.out.println("Введите название кешируемой директории: ");
                String dir = scanner.nextLine();
                dirFileCache = new DirFileCache(dir);
            } else if (select == 1) {
                if (dirFileCache == null) {
                    System.out.println("Название директории не указано!");
                    break;
                }
                System.out.println("Введите название кешируемого файла: ");
                String key = scanner.nextLine();
                dirFileCache.put(key, dirFileCache.load(key));
            } else if (select == 2) {
                    if (dirFileCache == null) {
                        System.out.println("Название директории не указано!");
                        break;
                    }
                System.out.println("Введите название файла который необходимо прочитать: ");
                    String read = scanner.nextLine();
                System.out.println(dirFileCache.get(read));
            } else if (select == 3) {
                run = false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DirFileCache dirFileCache = null;
        init(scanner, dirFileCache);
    }
}

