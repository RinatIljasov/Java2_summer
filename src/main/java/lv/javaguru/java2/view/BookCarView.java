package lv.javaguru.java2.view;

import lv.javaguru.java2.services.BookCarService;

import static lv.javaguru.java2.utils.ConsoleUtils.getMenuItemFromConsole;

public class BookCarView implements ConsoleView {

    private BookCarService bookCarService;
    private PrintCarsView printCarsView;
    private PrintCustomerView printCustomerView;

    public BookCarView(BookCarService bookCarService, PrintCarsView printCarsView, PrintCustomerView printCustomerView) {
        this.bookCarService = bookCarService;
        this.printCarsView = printCarsView;
        this.printCustomerView = printCustomerView;
    }

    @Override
    public void execute() {
        System.out.println();
        System.out.println("Cars: ");
        printCarsView.printCars();
        System.out.println("Select a car to book:");
        Integer carId = getMenuItemFromConsole(true);
        boolean customerCanBook = printCustomerView.customerCanBook(carId);
        boolean carIsBooked = printCustomerView.carIsBooked(carId);
        if (customerCanBook && !carIsBooked) {
            bookCarService.bookCar(carId);
            printCarsView.printBookedCarById(carId);
            printCustomerView.printCustomerBalance();
        }
        System.out.println();
    }


}
