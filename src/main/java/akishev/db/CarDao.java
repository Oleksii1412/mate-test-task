package akishev.db;

import akishev.model.Car;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface CarDao {
    Car add(Car car);

    Map<String, LinkedList<Car>> getAll();

    List<Car> getAllByBrand(String brand);

    List<Car> getAllByType(String type);
}
