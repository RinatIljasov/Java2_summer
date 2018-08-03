package lv.javaguru.java2.view;

import lv.javaguru.java2.domain.Car;
import lv.javaguru.java2.services.PrintCarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrintCarsView implements ConsoleView {

    @Autowired
    private PrintCarsService printCarsService;

    public void printCars() {
        printCarsService.getCars().forEach(System.out::println);
        System.out.println();
    }

    public void printBookedCarById(Long carId) {
        Car car = printCarsService.getCarById(carId);
        if (car != null) {
            System.out.println("Selected car is booked: " + car.getName());
        } else {
            System.out.println("Selected car not found.");
        }
    }

    public void printReturnedCarById(Long carId) {
        Car car = printCarsService.getCarById(carId);
        if (car != null) {
            System.out.println("Selected car is returned: " + car.getName());
        } else {
            System.out.println("Selected car not found.");
        }
    }

    @Override
    public void execute() {
        printCars();
    }

}
