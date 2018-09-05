package lv.javaguru.java2.businesslogic;

import lv.javaguru.java2.database.orm.CarRepositoryImpl;
import lv.javaguru.java2.utils.ConsoleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarValidatorImpl implements CarValidator {

    @Autowired
    private CarRepositoryImpl carRepository;

    public boolean checkIfCarCanBeReturned(long carId) {
        boolean carIsRented = carRepository.carIsBooked(carId);
        try {
            if (!carIsRented) {
                throw new ConsoleException("Selected car is not rented.");
            }
        } finally {
            return carIsRented;
        }
    }

    public boolean checkIfCarIsAlreadyBooked(long carId) {
        boolean carIsBooked = carRepository.carIsBooked(carId);
        try {
            if (carIsBooked) {
                throw new ConsoleException("Selected car is already booked.");
            }
        } finally {
            return carIsBooked;
        }
    }

    public boolean checkIfCustomerHasEnoughMoney(long carId, long customerId) {
        boolean customerCanBook = carRepository.customerCanBook(carId, customerId);
        try {
            if (!customerCanBook) {
                throw new ConsoleException("Customer has not enough money!");
            }
        } finally {
            return customerCanBook;
        }
    }
}
