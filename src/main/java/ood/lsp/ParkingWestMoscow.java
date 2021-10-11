package ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class ParkingWestMoscow implements Parking {

    private final int lengthSmall;
    private final int lengthBig;

    private final List<Car> smallCar = new ArrayList<>();
    private final List<Car> bigCar = new ArrayList<>();

    public ParkingWestMoscow(int lengthSmall, int lengthBig) {
        this.lengthSmall = lengthSmall;
        this.lengthBig = lengthBig;
    }

    @Override
    public boolean parkingCar(Car car) {
        if (car.getSize() == 1) {
            if (smallCar.size() < lengthSmall) {
                smallCar.add(car);
                return true;
            }
        } else if (car.getSize() > 1) {
            if (bigCar.size() < lengthBig) {
                bigCar.add(car);
                return true;
            } else if ((lengthSmall - smallCar.size()) > car.getSize()) {
                for (int i = 0; i < car.getSize(); i++) {
                    smallCar.add(car);
                }
                return true;
            }
        }
        return false;
    }
}
