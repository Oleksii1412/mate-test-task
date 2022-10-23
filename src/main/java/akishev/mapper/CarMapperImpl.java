package akishev.mapper;

import akishev.model.Car;
import akishev.strategy.StrategyHandler;
import java.util.Arrays;
import org.springframework.stereotype.Component;

@Component
public class CarMapperImpl implements CarMapper {
    private final StrategyHandler strategyHandler;

    public CarMapperImpl(StrategyHandler strategyHandler) {
        this.strategyHandler = strategyHandler;
    }

    @Override
    public Car toModel(String line) {
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
}
