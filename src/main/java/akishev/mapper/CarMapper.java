package akishev.mapper;

import akishev.model.Car;

public interface CarMapper {
    Car toModel(String line);
}
