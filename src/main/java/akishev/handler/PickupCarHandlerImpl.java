package akishev.handler;

import akishev.model.PickupCar;
import java.util.Scanner;

public class PickupCarHandlerImpl implements CarTypeHandler {

    @Override
    public PickupCar toModel(String car) {
        Scanner scanner = new Scanner(car);
        PickupCar pickupCar = new PickupCar();
        while (scanner.hasNext()) {
            scanner.useDelimiter("\\s*;\\s*");
            pickupCar.setBrand(scanner.next());
            pickupCar.setModel(scanner.next());
            pickupCar.setAccelerationTime(Double.parseDouble(scanner.next()));
            pickupCar.setTopSpeed(Integer.parseInt(scanner.next()));
            pickupCar.setFuelConsumption(Double.parseDouble(scanner.next()));
        }
        return pickupCar;
    }
}
