package akishev.handler;

import akishev.model.PickupCar;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class PickupCarHandlerImpl implements CarTypeHandler {

    @Override
    public PickupCar toModel(String car) {
        PickupCar pickupCar = new PickupCar();
        try (Scanner scanner = new Scanner(car)) {
            while (scanner.hasNext()) {
                scanner.useDelimiter("\\s*;\\s*");
                pickupCar.setBrand(scanner.next());
                pickupCar.setModel(scanner.next());
                pickupCar.setAccelerationTime(Double.parseDouble(scanner.next()));
                pickupCar.setTopSpeed(Integer.parseInt(scanner.next()));
                pickupCar.setFuelConsumption(Double.parseDouble(scanner.next()));
            }
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Some parameters are either "
                    + "empty or entered incorrectly!", e);
        }
        return pickupCar;
    }
}
