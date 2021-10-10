package ood.lsp;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingTest {

    @Ignore
    @Test
    public void parckingTrue() {
        Parking parking = new ParkingWestMoscow(2, 2);
        Car car1 = new Sedan();
        Car car2 = new Truck(2);
        Car car3 = new Sedan();
        parking.parkingCar(car1);
        parking.parkingCar(car2);
        assertTrue(parking.parkingCar(car3));
    }

    @Ignore
    @Test
    public void parckingFalse() {
        Parking parking = new ParkingWestMoscow(2, 2);
        Car car1 = new Sedan();
        Car car2 = new Truck(2);
        Car car3 = new Truck(2);
        parking.parkingCar(car1);
        parking.parkingCar(car2);
        assertFalse(parking.parkingCar(car3));
    }
}