package lv.javaguru.java2.view;

import lv.javaguru.java2.services.PrintCustomerService;

public class PrintCustomerView implements ConsoleView {
    private PrintCustomerService printCustomerService;

    public PrintCustomerView(PrintCustomerService printCustomerService) {
        this.printCustomerService = printCustomerService;
    }

    public void printCustomerBalance() {
        System.out.println("Customer " + printCustomerService.getCustomerName() + " balance: " + printCustomerService.getCustomerBalance() + "EUR");
        System.out.println();
    }

    public boolean customerCanBook(Integer carId) {
        boolean customerCanBook = printCustomerService.customerCanBook(carId);
        if (!customerCanBook) {
            System.out.println("Customer has not enough money!");
        }
        return customerCanBook;
    }

    public boolean carIsBooked(Integer carId) {
        boolean carIsBooked = printCustomerService.carIsBooked(carId);
        if (carIsBooked) {
            System.out.println("Selected car is already booked.");
        }
        return carIsBooked;
    }

    public boolean carIsRented(Integer carId) {
        boolean carIsRented = printCustomerService.carIsRented(carId);
        if (!carIsRented) {
            System.out.println("Selected car is not rented.");
        }
        return carIsRented;
    }

    @Override
    public void execute() {
        printCustomerBalance();
    }

}
