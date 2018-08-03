package lv.javaguru.java2.services;

import lv.javaguru.java2.database.Database;
import org.springframework.stereotype.Component;

@Component
public class CarValidatorImpl implements CarValidator {

    private Database database;

    public CarValidatorImpl(Database database) {
        this.database = database;
    }

    public boolean checkIfCarCanBeReturned(long carId) {
        boolean carIsRented = database.carIsBooked(carId);
        if (!carIsRented) {
            System.out.println("Selected car is not rented.");
        }
        return carIsRented;
    }

    public boolean checkIfCarIsAlreadyBooked(Long carId) {
        boolean carIsBooked = database.carIsBooked(carId);
        if (carIsBooked) {
            System.out.println("Selected car is already booked.");
        }
        return carIsBooked;
    }

    public boolean checkIfCustomerHasEnoughMoney(long carId, long customerId) {
        boolean customerCanBook = database.customerCanBook(carId, customerId);
        if (!customerCanBook) {
            System.out.println("Customer has not enough money!");
        }
        return customerCanBook;
    }
}
