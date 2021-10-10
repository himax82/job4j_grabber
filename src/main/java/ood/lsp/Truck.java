package ood.lsp;

public class Truck implements Car {

    private double size;

    public Truck(double size) {
        this.size = size;
    }

    @Override
    public double getSize() {
        return size;
    }
}
