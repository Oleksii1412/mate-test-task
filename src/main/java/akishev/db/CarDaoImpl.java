package akishev.db;

import akishev.model.Car;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
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
    public List<Car> getAllByBrand(String brand) {
        isNull(brand);
        return isEmpty(cars.values()
                .stream()
                .flatMap(LinkedList::stream)
                .filter(car -> car.getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toList()), brand);
    }

    @Override
    public List<Car> getAllByType(String type) {
        isNull(type);
       return isEmpty(cars.entrySet()
               .stream()
               .filter(key -> parseToType(key.getKey()).equalsIgnoreCase(type))
               .map(Map.Entry::getValue)
               .flatMap(LinkedList::stream)
               .collect(Collectors.toList()), type);
    }

    private String parseToType(String type) {
        String withSpaces = type.replaceAll(STRING_REGEX, " $1").trim();
        String substring = withSpaces.substring(0, withSpaces.lastIndexOf(" "));
        return substring.replaceAll(" ", "-");
    }

    private void isNull(String parameter) {
        if (parameter == null) {
            throw new RuntimeException("A parameter cannot be a null!");
        }
    }

    private List<Car> isEmpty(List<Car> cars, String parameter) {
        if (cars.isEmpty()) {
            throw new NoSuchElementException("Couldn't find cars by input parameter: " + parameter);
        }
        return cars;
    }
}
