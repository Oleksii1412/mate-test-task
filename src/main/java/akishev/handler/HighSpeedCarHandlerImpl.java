package akishev.handler;

import akishev.model.HighSpeedCar;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class HighSpeedCarHandlerImpl implements CarTypeHandler {

    @Override
    public HighSpeedCar toModel(String car) {
        HighSpeedCar highSpeedCar = new HighSpeedCar();
        try (Scanner scanner = new Scanner(car)) {
            while (scanner.hasNext()) {
                scanner.useDelimiter("\\s*;\\s*");
                highSpeedCar.setBrand(scanner.next());
                highSpeedCar.setModel(scanner.next());
                highSpeedCar.setAccelerationTime(Double.parseDouble(scanner.next()));
                highSpeedCar.setTopSpeed(Integer.parseInt(scanner.next()));
                highSpeedCar.setDriveType(scanner.next());
                highSpeedCar.setGearBox(scanner.next());
            }
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Some parameters are either "
                    + "empty or entered incorrectly!", e);
        }
        return highSpeedCar;
    }
}
