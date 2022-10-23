package akishev.handler;

import static org.junit.jupiter.api.Assertions.assertThrows;
import akishev.model.Car;
import akishev.model.HighSpeedCar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class HighSpeedCarHandlerImplTest {
    private static CarTypeHandler carTypeHandler;

    @BeforeAll
    static void beforeAll() {
        carTypeHandler = new HighSpeedCarHandlerImpl();
    }

    @Test
    public void toModel_ValidParameters_Ok(){
        HighSpeedCar expected = new HighSpeedCar();
        expected.setBrand("Ford");
        expected.setModel("Mustang");
        expected.setAccelerationTime(3.3);
        expected.setTopSpeed(320);
        expected.setDriveType("FWD");
        expected.setGearBox("7-speed automatic");
        String carParameters = "Ford; Mustang; 3.3; 320; FWD; 7-speed automatic";
        Car parsedCar = carTypeHandler.toModel(carParameters);
        Assertions.assertNotNull(parsedCar);
        Assertions.assertEquals(expected, parsedCar);
    }

    @Test
    public void toModel_InvalidParameters_NotOk(){
        String carParameters = "Ford; Mustang; 320; FWD; 7-speed automatic";
        assertThrows(RuntimeException.class, () -> carTypeHandler.toModel(carParameters),
                "RuntimeException to be thrown, but nothing was thrown");
    }
}
