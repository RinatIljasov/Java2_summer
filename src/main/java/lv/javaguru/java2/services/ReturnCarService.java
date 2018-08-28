package lv.javaguru.java2.services;

import lv.javaguru.java2.database.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReturnCarService {

    @Autowired
    private Database database;
    @Autowired
    private CarValidatorImpl carValidator;

    public void returnCar(long carId) {
        database.returnCar(carId);
    }

    public boolean checkIfCarCanBeReturned(long carId) {
        return carValidator.checkIfCarCanBeReturned(carId);
    }
}
