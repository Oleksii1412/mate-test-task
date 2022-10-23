package akishev.strategy;

import akishev.handler.CarTypeHandler;
import akishev.model.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.HashMap;
import java.util.Map;

class StrategyHandlerImplTest {
    private static final Car.CarType EXISTENT_CAR_TYPE_PATTERN = Car.CarType.ELECTRIC;
    private static StrategyHandler strategyHandler;
    private static CarTypeHandler carTypeHandler;

    @BeforeAll
    static void beforeAll() {
        carTypeHandler = Mockito.mock(CarTypeHandler.class);
        Map<Car.CarType, CarTypeHandler> handlerTypeMap = new HashMap<>();
        handlerTypeMap.put(EXISTENT_CAR_TYPE_PATTERN, carTypeHandler);
        strategyHandler = new StrategyHandlerImpl(handlerTypeMap);
    }

    @Test
    public void getTypeHandler_ExistentType_Ok() {
        Mockito.when(Mockito.spy(strategyHandler)
                .getTypeHandler(EXISTENT_CAR_TYPE_PATTERN)).thenReturn(carTypeHandler);
        CarTypeHandler retrievedTypeHandler
                = strategyHandler.getTypeHandler(EXISTENT_CAR_TYPE_PATTERN);
        Assertions.assertNotNull(retrievedTypeHandler);
        Assertions.assertEquals(carTypeHandler, retrievedTypeHandler);
    }
}
