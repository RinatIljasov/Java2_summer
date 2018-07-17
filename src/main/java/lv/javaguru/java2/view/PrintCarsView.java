package lv.javaguru.java2.view;

import lv.javaguru.java2.domain.Car;
import lv.javaguru.java2.services.PrintCarsService;

public class PrintCarsView implements ConsoleView {

    private PrintCarsService printCarsService;

    public PrintCarsView(PrintCarsService printCarsService) {
        this.printCarsService = printCarsService;
    }

    public void printCars() {
        printCarsService.getCars().forEach(System.out::println);
        System.out.println();
    }

    public void printBookedCarById(Integer carId) {
        Car car = printCarsService.getCarById(carId);
        if (car != null) {
            System.out.println("Selected car is booked: " + car.getName());
        } else {
            System.out.println("Selected car not found.");
        }
    }

    public void printReturnedCarById(Integer carId) {
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
