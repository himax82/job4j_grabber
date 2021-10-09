package ood.lsp;

public class AirBus {

    private int crew;
    private int fuel;
    boolean errors;

    public AirBus(int crew, int fuel, boolean errors) {
        this.crew = crew;
        this.fuel = fuel;
        this.errors = errors;
    }

    public boolean permissionToFly() {
        return crew >= 2 && fuel >= 10_000 && !errors;
    }

    class AirBus320 extends AirBus {

        public AirBus320(int crew, int fuel, boolean errors) {
            super(crew, fuel, errors);
        }

        @Override
        public boolean permissionToFly() {
            return crew >= 2 && !errors;
        }
    }
}
