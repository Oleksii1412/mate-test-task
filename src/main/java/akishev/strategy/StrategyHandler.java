package akishev.strategy;

import akishev.handler.CarTypeHandler;
import akishev.model.Car;

public interface StrategyHandler {
    CarTypeHandler getTypeHandler(Car.CarType type);
}
