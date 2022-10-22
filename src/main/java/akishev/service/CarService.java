package akishev.service;

import akishev.model.Car;
import java.util.List;

public interface CarService {
    Car add(String line);

    void printAll();

    List<Car> getAllByBrand(String brand);

    List<Car> getAllByType(String type);
}
