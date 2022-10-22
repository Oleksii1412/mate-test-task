package akishev.db;

import akishev.model.Car;
import java.util.List;

public interface CarDao {
    Car add(Car car);

    List<Car> getAll();
}
