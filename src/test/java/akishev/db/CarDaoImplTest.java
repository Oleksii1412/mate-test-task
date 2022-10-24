package akishev.db;

import static org.junit.jupiter.api.Assertions.assertThrows;
import akishev.model.Car;
import akishev.model.ElectricCar;
import akishev.model.PickupCar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

class CarDaoImplTest {
    private static final String EXISTENT_CAR_BRAND = "Toyota";
    private static final String NOT_EXISTENT_CAR_BRAND = "None";
    private static final String EXISTENT_CAR_TYPE = "Electric";
    private static final String NOT_EXISTENT_CAR_TYPE = "None";
    private static CarDao carDao;
    private static PickupCar pickupCar;
    private static ElectricCar electricCar;
    private static Map<String, LinkedList<Car>> cars;

    @BeforeAll
    static void beforeAll() {
        cars = new HashMap<>();
        carDao = new CarDaoImpl(cars);
        pickupCar = createPickupCar();
        electricCar = createElectricCar();
    }

    @BeforeEach
    void clean() {
        cars.clear();
    }

    @Test
    public void add_ValidCar_Ok() {
        Car addedCar = carDao.add(pickupCar);
        Assertions.assertNotNull(addedCar);
        Assertions.assertEquals(pickupCar, addedCar);
    }

    @Test
    public void getAll_NoCars_Ok() {
        int expected = 0;
        int actual = carDao.getAll().size();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getAllByBrand_ExistentBrand_Ok() {
        List<Car> expected = new ArrayList<>();
        expected.add(pickupCar);
        carDao.add(pickupCar);
        List<Car> actual = carDao.getAllByBrand(EXISTENT_CAR_BRAND);
        Assertions.assertFalse(actual.isEmpty());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getAllByBrand_NullBrand_NotOk() {
        carDao.add(pickupCar);
        assertThrows(RuntimeException.class,
                () -> carDao.getAllByBrand(null),
                "RuntimeException to be thrown, but nothing was thrown");
    }

    @Test
    public void getAllByBrand_NotExistentBrand_NotOk() {
        carDao.add(pickupCar);
        assertThrows(NoSuchElementException.class,
                () -> carDao.getAllByBrand(NOT_EXISTENT_CAR_BRAND),
                "NoSuchElementException to be thrown, but nothing was thrown");
    }

    @Test
    public void getAllByType_ExistentType_Ok() {
        List<Car> expected = new ArrayList<>();
        expected.add(electricCar);
        carDao.add(electricCar);
        List<Car> actual = carDao.getAllByType(EXISTENT_CAR_TYPE);
        Assertions.assertFalse(actual.isEmpty());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getAllByType_NullType_NotOk() {
        carDao.add(electricCar);
        assertThrows(RuntimeException.class,
                () -> carDao.getAllByType(null),
                "RuntimeException to be thrown, but nothing was thrown");
    }

    @Test
    public void getAllByType_NotExistentType_NotOk() {
        carDao.add(electricCar);
        assertThrows(NoSuchElementException.class,
                () -> carDao.getAllByType(NOT_EXISTENT_CAR_TYPE),
                "NoSuchElementException to be thrown, but nothing was thrown");
    }

    private static PickupCar createPickupCar() {
        PickupCar pickupCar = new PickupCar();
        pickupCar.setBrand("Toyota");
        pickupCar.setModel("Tundra");
        pickupCar.setAccelerationTime(7.2);
        pickupCar.setTopSpeed(250);
        pickupCar.setFuelConsumption(13.3);
        return pickupCar;
    }

    private static ElectricCar createElectricCar() {
        ElectricCar electricCar = new ElectricCar();
        electricCar.setBrand("Nissan");
        electricCar.setModel("Leaf");
        electricCar.setAccelerationTime(5.2);
        electricCar.setTopSpeed(220);
        electricCar.setRange(200);
        electricCar.setBatteryCapacity(80);
        electricCar.setBatteryWarranty(5);
        return electricCar;
    }
}
