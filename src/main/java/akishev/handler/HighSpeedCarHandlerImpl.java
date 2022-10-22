package akishev.handler;

import akishev.model.HighSpeedCar;
import java.util.Scanner;

public class HighSpeedCarHandlerImpl implements CarTypeHandler {

    @Override
    public HighSpeedCar toModel(String car) {
        Scanner scanner = new Scanner(car);
        HighSpeedCar highSpeedCar = new HighSpeedCar();
        while (scanner.hasNext()) {
            scanner.useDelimiter("\\s*;\\s*");
            highSpeedCar.setBrand(scanner.next());
            highSpeedCar.setModel(scanner.next());
            highSpeedCar.setAccelerationTime(Double.parseDouble(scanner.next()));
            highSpeedCar.setTopSpeed(Integer.parseInt(scanner.next()));
            highSpeedCar.setDriveType(scanner.next());
            highSpeedCar.setGearBox(scanner.next());
        }
        return highSpeedCar;
    }
}
