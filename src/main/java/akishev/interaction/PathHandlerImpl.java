package akishev.interaction;

import java.util.Scanner;
import org.springframework.stereotype.Component;

@Component
public class PathHandlerImpl implements PathHandler {
    private final Scanner scanner;

    public PathHandlerImpl(Scanner scanner) {
        this.scanner = scanner;
    }

    public String setInputFilePath() {
        System.out.println("\nHello! This is a car service application which "
                + "gives to you opportunity work with the cars catalogue.");
        System.out.println("Could you be so kind and provide a file path to get an input data.\n");
        System.out.println("Please, type your path then press enter, "
                + "as e.g: src/main/resources/cars.txt");
        System.out.println("Enter path here: ");
        return scanner.nextLine();
    }
}
