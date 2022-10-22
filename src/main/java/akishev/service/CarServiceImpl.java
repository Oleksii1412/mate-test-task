package akishev.service;

import akishev.db.CarDao;
import akishev.model.Car;
import akishev.strategy.StrategyHandler;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class CarServiceImpl implements CarService {
    private static final String STRING_REGEX = "([A-Z])";
    private final StrategyHandler strategyHandler;
    private final CarDao carDao;

    public CarServiceImpl(StrategyHandler strategyHandler, CarDao carDao) {
        this.strategyHandler = strategyHandler;
        this.carDao = carDao;
    }

    @Override
    public Car add(String line) {
        return carDao.add(toModel(line));
    }

    @Override
    public void printAll() {
        carDao.getAll().forEach(System.out::println);
    }

    @Override
    public List<Car> getAllByBrand(String brand) {
        return carDao.getAll().stream()
                .filter(car -> car.getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> getAllByType(String type) {
        return carDao.getAll().stream()
                .filter(car -> parseToType(car.getClass().getSimpleName())
                        .equalsIgnoreCase(type))
                .collect(Collectors.toList());
    }

    private Car toModel(String line) {
        int index = line.contains(" ") ? line.indexOf(" ") : 0;
        if (index != 0) {
            String header = line.substring(0, index);
            String car = line.substring(index).trim();
            Car.CarType carType = getCarType(header);
            return strategyHandler.getTypeHandler(carType).toModel(car);
        }
        throw new RuntimeException("Inputted parameters are invalid! " + line);
    }

    private Car.CarType getCarType(String header) {
        return Arrays.stream(Car.CarType.values())
                .filter(h -> h.getType().equalsIgnoreCase(header))
                .findFirst().orElseThrow(
                        () -> new RuntimeException("Can't find enum "
                                + "by input type: " + header));
    }

    private String parseToType(String type) {
        String withSpaces = type.replaceAll(STRING_REGEX, " $1").trim();
        String substring = withSpaces.substring(0, withSpaces.lastIndexOf(" "));
        return substring.replaceAll(" ", "-");
    }
}
