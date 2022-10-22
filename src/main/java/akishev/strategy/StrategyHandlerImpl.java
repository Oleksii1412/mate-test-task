package akishev.strategy;

import akishev.handler.CarTypeHandler;
import akishev.model.Car;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class StrategyHandlerImpl implements StrategyHandler {
    private final Map<Car.CarType, CarTypeHandler> handlerMap;

    public StrategyHandlerImpl(Map<Car.CarType, CarTypeHandler> handlerType) {
        handlerMap = handlerType;
    }

    @Override
    public CarTypeHandler getTypeHandler(Car.CarType type) {
        return handlerMap.get(type);
    }
}
