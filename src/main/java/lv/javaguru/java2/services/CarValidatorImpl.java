package lv.javaguru.java2.services;

import lv.javaguru.java2.database.Database;
import lv.javaguru.java2.utils.ConsoleException;
import org.springframework.stereotype.Component;

@Component
public class CarValidatorImpl implements CarValidator {

    private Database database;

    public CarValidatorImpl(Database database) {
        this.database = database;
    }

    public boolean checkIfCarCanBeReturned(long carId) {
        boolean carIsRented = database.carIsBooked(carId);
        try {
            if (!carIsRented) {
                throw new ConsoleException("Selected car is not rented.");
            }
        } finally {
            return carIsRented;
        }
    }

    public boolean checkIfCarIsAlreadyBooked(long carId) {
        boolean carIsBooked = database.carIsBooked(carId);
        try {
            if (carIsBooked) {
                throw new ConsoleException("Selected car is already booked.");
            }
        } finally {
            return carIsBooked;
        }
    }

    public boolean checkIfCustomerHasEnoughMoney(long carId, long customerId) {
        boolean customerCanBook = database.customerCanBook(carId, customerId);
        try {
            if (!customerCanBook) {
                throw new ConsoleException("Customer has not enough money!");
            }
        } finally {
            return customerCanBook;
        }
    }
}
