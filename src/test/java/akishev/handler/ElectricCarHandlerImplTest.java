package akishev.handler;

import static org.junit.jupiter.api.Assertions.assertThrows;
import akishev.model.Car;
import akishev.model.ElectricCar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ElectricCarHandlerImplTest {
    private static CarTypeHandler carTypeHandler;

    @BeforeAll
    static void beforeAll() {
        carTypeHandler = new ElectricCarHandlerImpl();
    }

    @Test
    public void toModel_ValidParameters_Ok(){
        ElectricCar expected = new ElectricCar();
        expected.setBrand("Nissan");
        expected.setModel("Leaf");
        expected.setAccelerationTime(5.2);
        expected.setTopSpeed(220);
        expected.setRange(200);
        expected.setBatteryCapacity(80);
        expected.setBatteryWarranty(5);
        String carParameters = "Nissan; Leaf; 5.2; 220; 200; 80; 5";
        Car parsedCar = carTypeHandler.toModel(carParameters);
        Assertions.assertNotNull(parsedCar);
        Assertions.assertEquals(expected, parsedCar);
    }

    @Test
    public void toModel_InvalidParameters_NotOk(){
        String carParameters = "Nissan; LEAF; 5.2; 220; 200;";
        assertThrows(RuntimeException.class, () -> carTypeHandler.toModel(carParameters),
                "RuntimeException to be thrown, but nothing was thrown");
    }
}
