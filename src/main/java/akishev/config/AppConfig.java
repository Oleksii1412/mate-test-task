package akishev.config;

import akishev.handler.CarTypeHandler;
import akishev.handler.ElectricCarHandlerImpl;
import akishev.handler.HighSpeedCarHandlerImpl;
import akishev.handler.PickupCarHandlerImpl;
import akishev.model.Car;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "akishev")
public class AppConfig {
    @Bean
    public Map<String, LinkedList<Car>> createCarMap() {
        return new HashMap<>();
    }

    @Bean
    public Scanner createScanner() {
        return new Scanner(System.in);
    }

    @Bean
    public Map<Car.CarType, CarTypeHandler> createHandler() {
        Map<Car.CarType, CarTypeHandler> map = new HashMap<>();
        map.put(Car.CarType.HIGH_SPEED, new HighSpeedCarHandlerImpl());
        map.put(Car.CarType.ELECTRIC, new ElectricCarHandlerImpl());
        map.put(Car.CarType.PICKUP, new PickupCarHandlerImpl());
        return map;
    }
}
