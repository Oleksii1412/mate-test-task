package akishev.interaction;

import akishev.mapper.CarMapper;
import akishev.model.Car;
import akishev.service.CarService;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.springframework.stereotype.Component;

@Component
public class AppInterfaceImpl implements AppInterface {
    private final CarService carService;
    private final CarMapper carMapper;
    private final Scanner scanner;

    public AppInterfaceImpl(CarService carService,
                            CarMapper carMapper,
                            Scanner scanner) {
        this.carService = carService;
        this.carMapper = carMapper;
        this.scanner = scanner;
    }

    @Override
    public void runApp() {
        System.out.println("Data was successfully read from the input file.\n");
        System.out.println("Now, you are able to work with the cars catalogue!");
        while (true) {
            System.out.println("\nPlease, make your choice:\n");
            System.out.println("1. Show the entire cars catalog\n"
                    + "2. Add a new high-speed car\n"
                    + "3. Add a new electric car\n"
                    + "4. Add a new pickup car\n"
                    + "5. Show all cars of a particular brand \n"
                    + "6. Show all cars of a particular type \n"
                    + "7. Stop the program\n");
            System.out.print("Enter number here: \n");
            try {
                int i = scanner.nextInt();
                scanner.nextLine();
                switch (i) {
                    case 1:
                        System.out.println("You have chose an Option 1.");
                        System.out.println("Here, you got the entire cars catalog: ");
                        printAll(carService.getAll());
                        continue;
                    case 2:
                        System.out.println("You have chose an Option 2.");
                        System.out.println("Please, enter parameters for a new high-speed car: ");
                        carService.add(carMapper.toModel(scanner.nextLine()));
                        continue;
                    case 3:
                        System.out.println("You have chose an Option 3.");
                        System.out.println("Please, enter parameters for a new electric car: ");
                        carService.add(carMapper.toModel(scanner.nextLine()));
                        continue;
                    case 4:
                        System.out.println("You have chose an Option 4.");
                        System.out.println("Please, enter parameters for a new pickup car: ");
                        carService.add(carMapper.toModel(scanner.nextLine()));
                        continue;
                    case 5:
                        System.out.println("You have chose an Option 5.");
                        System.out.println("Please, enter a brand name: ");
                        printAllByParameter(carService.getAllByBrand(scanner.nextLine()));
                        continue;
                    case 6:
                        System.out.println("You have chose an Option 6.");
                        System.out.println("Please, enter a type name: ");
                        printAllByParameter(carService.getAllByType(scanner.nextLine()));
                        continue;
                    case 7:
                        System.out.println("Good bye!");
                        break;
                    default:
                        System.out.println("\nYou didn't choose a correct variant! "
                                + "Please try again! Enter a number from 1 to 7!");
                        continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input! Please, enter a number! Try again!");
                scanner.nextLine();
                continue;
            }
            return;
        }
    }

    private void printAll(Map<String, LinkedList<Car>> cars) {
        cars.values()
                .stream()
                .flatMap(LinkedList::stream)
                .forEach(System.out::println);
    }

    private void printAllByParameter(List<Car> cars) {
        cars.forEach(System.out::println);
    }
}
