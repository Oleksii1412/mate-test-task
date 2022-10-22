package akishev.handler;

import akishev.model.ElectricCar;
import java.util.Scanner;

public class ElectricCarHandlerImpl implements CarTypeHandler {

    @Override
    public ElectricCar toModel(String car) {
        Scanner scanner = new Scanner(car);
        ElectricCar electricCar = new ElectricCar();
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
        return electricCar;
    }
}
