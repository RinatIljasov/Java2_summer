package lv.javaguru.java2.services;

import lv.javaguru.java2.database.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookCarService {

    @Autowired
    private Database database;
    @Autowired
    private CarValidatorImpl carValidator;

    public void bookCar(long carId, long customerId) {
        database.bookCar(carId, customerId);
    }

    public boolean checkIfCustomerHasEnoughMoney(long carId, long customerId) {
        return carValidator.checkIfCustomerHasEnoughMoney(carId, customerId);
    }

    public boolean checkIfCarIsAlreadyBooked(long carId) {
        return carValidator.checkIfCarIsAlreadyBooked(carId);
    }
}
