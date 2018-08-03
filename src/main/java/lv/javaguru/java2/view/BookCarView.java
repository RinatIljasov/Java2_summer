package lv.javaguru.java2.view;

import lv.javaguru.java2.services.BookCarService;
import lv.javaguru.java2.services.CarValidatorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static lv.javaguru.java2.utils.ConsoleUtils.getMenuItemFromConsole;

@Component
public class BookCarView implements ConsoleView {

    @Autowired
    private BookCarService bookCarService;
    @Autowired
    private PrintCarsView printCarsView;
    @Autowired
    private PrintCustomerView printCustomerView;

    @Override
    public void execute() {
        System.out.println();
        System.out.println("Cars: ");
        printCarsView.printCars();
        System.out.println("Select a car to book:");
        Integer carId = getMenuItemFromConsole(true);
        boolean customerCanBook = bookCarService.checkIfCustomerHasEnoughMoney(carId.longValue(), 1);
        boolean carIsBooked = bookCarService.checkIfCarIsAlreadyBooked(carId.longValue());
        if (customerCanBook && !carIsBooked) {
            bookCarService.bookCar(carId.longValue());
            printCarsView.printBookedCarById(carId.longValue());
            printCustomerView.printCustomerBalance();
        }
        System.out.println();
    }


}
