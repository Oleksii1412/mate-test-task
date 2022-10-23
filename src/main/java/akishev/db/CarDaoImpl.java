package akishev.db;

import akishev.model.Car;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class CarDaoImpl implements CarDao {
    private static final String STRING_REGEX = "([A-Z])";
    private final Map<String, LinkedList<Car>> cars;

    public CarDaoImpl(Map<String,
            LinkedList<Car>> cars) {
        this.cars = cars;
    }

    @Override
    public Car add(Car car) {
        if (cars.computeIfAbsent(car.getClass().getSimpleName(),
                c -> new LinkedList<>()).add(car)) {
            return car;
        } else {
            cars.get(car.getClass().getSimpleName()).add(car);
        }
        return car;
    }

    @Override
    public Map<String, LinkedList<Car>> getAll() {
        return cars;
    }

    @Override
    public Optional<List<Car>> getAllByBrand(String brand) {
        return Optional.of(cars.values()
                .stream()
                .flatMap(LinkedList::stream)
                .filter(car -> car.getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toList()));
    }

    @Override
    public Optional<List<Car>> getAllByType(String type) {
       return Optional.of(cars.entrySet()
               .stream()
               .filter(key -> parseToType(key.getKey()).equalsIgnoreCase(type))
               .map(Map.Entry::getValue)
               .flatMap(LinkedList::stream)
               .collect(Collectors.toList()));
    }

    private String parseToType(String type) {
        String withSpaces = type.replaceAll(STRING_REGEX, " $1").trim();
        String substring = withSpaces.substring(0, withSpaces.lastIndexOf(" "));
        return substring.replaceAll(" ", "-");
    }
}
