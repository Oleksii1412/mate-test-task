package akishev.service;

import akishev.db.CarDao;
import akishev.model.Car;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Component;

@Component
public class CarServiceImpl implements CarService {
    private final CarDao carDao;

    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    public Car add(Car car) {
        return carDao.add(car);
    }

    @Override
    public Map<String, LinkedList<Car>> getAll() {
        return carDao.getAll();
    }

    @Override
    public List<Car> getAllByBrand(String brand) {
        return carDao.getAllByBrand(brand).orElseThrow(
                () -> new NoSuchElementException("Couldn't find cars by input brand: " + brand));
    }

    @Override
    public List<Car> getAllByType(String type) {
        return carDao.getAllByType(type).orElseThrow(
                () -> new NoSuchElementException("Couldn't find cars by input type: " + type));
    }
}
