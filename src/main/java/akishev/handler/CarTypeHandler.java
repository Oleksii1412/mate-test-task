package akishev.handler;

import akishev.model.Car;

public interface CarTypeHandler {
    Car toModel(String car);
}
