package akishev.db;

import akishev.model.Car;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class CarDaoImpl implements CarDao {
    private final List<Car> cars;

    public CarDaoImpl(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public Car add(Car car) {
        cars.add(car);
        return car;
    }

    @Override
    public List<Car> getAll() {
        return cars;
    }
}
