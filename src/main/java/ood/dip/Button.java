package ood.dip;

public class Button {
    private Lamp lamp;
    private String light;

    public void poll() {
        if (light.equals("Ночь")) {
            lamp.turnOn();
        }
    }
}
