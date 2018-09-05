package lv.javaguru.java2.view;

import lv.javaguru.java2.businesslogic.bookcar.BookCarService;
import lv.javaguru.java2.domain.Customer;
import lv.javaguru.java2.view.ConsoleView;
import lv.javaguru.java2.view.PrintCarsView;
import lv.javaguru.java2.view.PrintCustomerView;
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
        boolean customerCanBook = bookCarService.checkIfCustomerHasEnoughMoney(carId.longValue(), Customer.CUSTOMER_ID);
        boolean carIsBooked = bookCarService.checkIfCarIsAlreadyBooked(carId.longValue());
        if (customerCanBook && !carIsBooked) {
            bookCarService.bookCar(carId.longValue(), Customer.CUSTOMER_ID);
            printCarsView.printBookedCarById(carId.longValue());
            printCustomerView.printCustomerBalance();
        }
        System.out.println();
    }


}
