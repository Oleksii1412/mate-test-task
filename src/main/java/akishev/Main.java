package akishev;

import akishev.config.AppConfig;
import akishev.interaction.DataHandler;
import akishev.interaction.PathHandler;
import akishev.reader.FileReader;
import akishev.service.CarService;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);
        CarService carService = context.getBean(CarService.class);

        PathHandler pathHandler = context.getBean(PathHandler.class);
        String inputPathFile = pathHandler.setInputFilePath();

        FileReader fileReader = context.getBean(FileReader.class);
        List<String> data = fileReader.readFromFile(inputPathFile);

        data.forEach(carService::add);

        DataHandler dataHandler = context.getBean(DataHandler.class);
        dataHandler.runApp();
    }
}
