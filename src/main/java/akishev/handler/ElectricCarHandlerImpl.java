package akishev.handler;

import akishev.model.ElectricCar;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ElectricCarHandlerImpl implements CarTypeHandler {

    @Override
    public ElectricCar toModel(String car) {
        ElectricCar electricCar = new ElectricCar();
        try (Scanner scanner = new Scanner(car)) {
            while (scanner.hasNext()) {
                scanner.useDelimiter("\\s*;\\s*");
                electricCar.setBrand(scanner.next());
                electricCar.setModel(scanner.next());
                electricCar.setAccelerationTime(Double.parseDouble(scanner.next()));
                electricCar.setTopSpeed(Integer.parseInt(scanner.next()));
                electricCar.setRange(Integer.parseInt(scanner.next()));
                electricCar.setBatteryCapacity(Integer.parseInt(scanner.next()));
                electricCar.setBatteryWarranty(Integer.parseInt(scanner.next()));
            }
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Some parameters are either "
                    + "empty or entered incorrectly!", e);
        }
        return electricCar;
    }
}
