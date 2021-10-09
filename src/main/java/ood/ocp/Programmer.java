package ood.ocp;

public class Programmer {

    public void work() {
        System.out.println("Write code.");
    }

    static class Tester extends Programmer {

        @Override
        public void work() {
            System.out.println("Testing code.");
        }
    }
}
