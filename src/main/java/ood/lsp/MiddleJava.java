package ood.lsp;

public class MiddleJava {

    private int salary;

    public MiddleJava(int salary) {
        this.salary = salary;
    }

    public void toPay() {
        if (salary > 100_000) {
            System.out.printf("Переводим на счет %d рублей", salary);
        } else {
            System.out.println("Зарплата мидла не может быть меньше 100 000 рублей");
        }
    }

    class SeniorJava extends MiddleJava {

        public SeniorJava(int salary) {
            super(salary);
        }

        @Override
        public void toPay() {
            if (salary > 150_000) {
                System.out.printf("Переводим на счет %d рублей", salary);
            } else {
                System.out.println("Зарплата мидла не может быть меньше 100 000 рублей");
            }
        }
    }
}
