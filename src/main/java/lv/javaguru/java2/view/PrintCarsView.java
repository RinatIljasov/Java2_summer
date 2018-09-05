package lv.javaguru.java2.view;

import lv.javaguru.java2.businesslogic.printcar.PrintCarsService;
import lv.javaguru.java2.domain.Car;
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

    public void printBookedCarById(long carId) {
        Car car = printCarsService.getCarById(carId);
        if (car != null) {
            System.out.println("Selected car is booked: " + car.getManufacturer());
        } else {
            System.out.println("Selected car not found.");
        }
    }

    public void printReturnedCarById(long carId) {
        Car car = printCarsService.getCarById(carId);
        if (car != null) {
            System.out.println("Selected car is returned: " + car.getManufacturer());
        } else {
            System.out.println("Selected car not found.");
        }
    }

    @Override
    public void execute() {
        printCars();
    }

}
