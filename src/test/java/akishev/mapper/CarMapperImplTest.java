package akishev.mapper;

import static org.junit.jupiter.api.Assertions.assertThrows;
import akishev.handler.CarTypeHandler;
import akishev.model.Car;
import akishev.model.ElectricCar;
import akishev.strategy.StrategyHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.NoSuchElementException;

class CarMapperImplTest {
    private static final String VALID_CAR_PARAMETERS_WITH_TYPE
            = "ELECTRIC Nissan; LEAF; 5.2; 220; 200; 80; 5";
    private static final String VALID_CAR_PARAMETERS_WITHOUT_TYPE
            ="Nissan; LEAF; 5.2; 220; 200; 80; 5";
    private static final Car.CarType CAR_TYPE = Car.CarType.ELECTRIC;
    private static StrategyHandler strategyHandler;
    private static CarTypeHandler carTypeHandler;
    private static CarMapper carMapper;

    @BeforeAll
    static void beforeAll() {
        carTypeHandler = Mockito.mock(CarTypeHandler.class);
        strategyHandler = Mockito.mock(StrategyHandler.class);
        carMapper = new CarMapperImpl(strategyHandler);
    }

    @Test
    public void toModel_ValidParameters_Ok() {
        ElectricCar expected = new ElectricCar();
        expected.setBrand("Nissan");
        expected.setModel("Leaf");
        expected.setAccelerationTime(5.2);
        expected.setTopSpeed(220);
        expected.setRange(200);
        expected.setBatteryCapacity(80);
        expected.setBatteryWarranty(5);
        Mockito.when(strategyHandler.getTypeHandler(CAR_TYPE)).thenReturn(carTypeHandler);
        Mockito.when(carTypeHandler.toModel(VALID_CAR_PARAMETERS_WITHOUT_TYPE))
                .thenReturn(expected);
        Car mappedCar = carMapper.toModel(VALID_CAR_PARAMETERS_WITH_TYPE);
        Assertions.assertNotNull(mappedCar);
        Assertions.assertEquals(expected, mappedCar);
    }

    @Test
    public void toModel_NotExistentCarType_NotOk() {
        String line = "HYBRID Toyota; Rav4; 4.8; 250; 200; 110; 10";
        assertThrows(NoSuchElementException.class, () -> carMapper.toModel(line),
                "NoSuchElementException to be thrown, but nothing was thrown");
    }

    @Test
    public void toModel_InvalidInputParameters_NotOk() {
        String line = "ELECTRICNissanLEAF5.2220200;80;5";
        assertThrows(RuntimeException.class, () -> carMapper.toModel(line),
        "RuntimeException to be thrown, but nothing was thrown");
    }

    @Test
    public void toModel_NullInput_NotOk() {
        assertThrows(RuntimeException.class, () -> carMapper.toModel(null),
                "RuntimeException to be thrown, but nothing was thrown");
    }
}
