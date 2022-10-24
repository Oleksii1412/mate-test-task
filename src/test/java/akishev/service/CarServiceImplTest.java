package akishev.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import akishev.db.CarDao;
import akishev.model.Car;
import akishev.model.HighSpeedCar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

class CarServiceImplTest {
    private static final String EXISTENT_CAR_BRAND_PATTERN = "Ford";
    private static final String NOT_EXISTENT_CAR_BRAND_PATTERN = "None";
    private static final String EXISTENT_CAR_TYPE_PATTERN = "High-speed";
    private static final String NOT_EXISTENT_CAR_TYPE_PATTERN = "None";
    private static Map<String, LinkedList<Car>> cars;
    private static CarService carService;
    private static CarDao carDao;
    private static Car car;

    @BeforeAll
    static void beforeAll() {
        carDao = Mockito.mock(CarDao.class);
        car = Mockito.mock(Car.class);
        carService = new CarServiceImpl(carDao);
        cars = new HashMap<>();
        LinkedList<Car> carLinkedList = new LinkedList<>();
        carLinkedList.add(car);
        cars.put(Car.class.getSimpleName(), carLinkedList);
    }

    @Test
    public void add_Ok() {
        Mockito.when(carDao.add(any(Car.class))).thenReturn(car);
        Car savedCar = carService.add(car);
        Assertions.assertNotNull(savedCar);
        Assertions.assertEquals(car, savedCar);
    }

    @Test
    public void getAll_WithCar_Ok() {
        Mockito.when(carDao.getAll()).thenReturn(cars);
        Map<String, LinkedList<Car>> retrievedCars = carService.getAll();
        Assertions.assertNotNull(retrievedCars);
        Assertions.assertEquals(cars, retrievedCars);
    }

    @Test
    public void getAllByBrand_ExistentBrand_Ok() {
        List<Car> expected = new ArrayList<>();
        car.setBrand(EXISTENT_CAR_BRAND_PATTERN);
        expected.add(car);
        Mockito.when(carDao.getAllByBrand(EXISTENT_CAR_BRAND_PATTERN))
                .thenReturn(expected);
        List<Car> retrievedByBrand = carService.getAllByBrand(EXISTENT_CAR_BRAND_PATTERN);
        Assertions.assertNotNull(retrievedByBrand);
        Assertions.assertEquals(expected, retrievedByBrand);
    }

    @Test
    public void getAllByBrand_NotExistentBrand_NotOk() {
        Mockito.when(carDao.getAllByBrand(NOT_EXISTENT_CAR_BRAND_PATTERN))
                .thenThrow(NoSuchElementException.class);
        assertThrows(RuntimeException.class,
                () -> carService.getAllByBrand(NOT_EXISTENT_CAR_BRAND_PATTERN),
                "NoSuchElementException to be thrown, but nothing was thrown");
    }

    @Test
    public void getAllByBrand_NullBrand_NotOk() {
        Mockito.when(carDao.getAllByBrand(null))
                .thenThrow(RuntimeException.class);
        assertThrows(RuntimeException.class,
                () -> carService.getAllByBrand(null),
                "RuntimeException to be thrown, but nothing was thrown");
    }

    @Test
    public void getAllByType_ExistentType_Ok() {
        List<Car> expected = new ArrayList<>();
        expected.add(new HighSpeedCar());
        Mockito.when(carDao.getAllByType(EXISTENT_CAR_TYPE_PATTERN))
                .thenReturn(expected);
        List<Car> retrievedByType = carService.getAllByType(EXISTENT_CAR_TYPE_PATTERN);
        Assertions.assertNotNull(retrievedByType);
        Assertions.assertEquals(expected, retrievedByType);
    }

    @Test
    public void getAllByType_NotExistentType_NotOk() {
        Mockito.when(carDao.getAllByType(NOT_EXISTENT_CAR_TYPE_PATTERN))
                .thenThrow(NoSuchElementException.class);
        assertThrows(NoSuchElementException.class,
                () -> carService.getAllByType(NOT_EXISTENT_CAR_TYPE_PATTERN),
                "NoSuchElementException to be thrown, but nothing was thrown");
    }

    @Test
    public void getAllByType_NullType_NotOk() {
        Mockito.when(carDao.getAllByType(null))
                .thenThrow(RuntimeException.class);
        assertThrows(RuntimeException.class,
                () -> carService.getAllByType(null),
                "RuntimeException to be thrown, but nothing was thrown");
    }
}
