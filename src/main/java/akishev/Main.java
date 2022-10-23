package akishev;

import akishev.config.AppConfig;
import akishev.interaction.DataHandler;
import akishev.interaction.PathHandler;
import akishev.mapper.CarMapper;
import akishev.model.Car;
import akishev.reader.FileReader;
import akishev.service.CarService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);

        PathHandler pathHandler = context.getBean(PathHandler.class);
        String inputPathFile = pathHandler.setInputFilePath();

        FileReader fileReader = context.getBean(FileReader.class);
        List<String> data = fileReader.readFromFile(inputPathFile);
        CarMapper carMapper = context.getBean(CarMapper.class);
        List<Car> cars = data.stream()
                .map(carMapper::toModel)
                .collect(Collectors.toList());

        CarService carService = context.getBean(CarService.class);
        cars.forEach(carService::add);

        DataHandler dataHandler = context.getBean(DataHandler.class);
        dataHandler.runApp();
    }
}
