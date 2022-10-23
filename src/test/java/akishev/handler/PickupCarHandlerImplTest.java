package akishev.handler;

import akishev.model.Car;
import akishev.model.PickupCar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PickupCarHandlerImplTest {
    private static CarTypeHandler carTypeHandler;

    @BeforeAll
    static void beforeAll() {
        carTypeHandler = new PickupCarHandlerImpl();
    }

    @Test
    public void toModel_ValidParameters_Ok(){
        PickupCar expected = new PickupCar();
        expected.setBrand("Nissan");
        expected.setModel("Leaf");
        expected.setAccelerationTime(5.2);
        expected.setTopSpeed(220);
        expected.setFuelConsumption(13.3);
        String carParameters = "PICKUP Toyota; Tundra; 7.2; 250; 13.3";
        Car parsedCar = carTypeHandler.toModel(carParameters);
        Assertions.assertNotNull(parsedCar);
        Assertions.assertEquals(expected, parsedCar);
    }

    @Test
    public void toModel_InvalidParameters_NotOk(){
        String carParameters = "Toyota; Tundra; 250; 13.3;";
        assertThrows(RuntimeException.class, () -> carTypeHandler.toModel(carParameters),
                "RuntimeException to be thrown, but nothing was thrown");
    }
}