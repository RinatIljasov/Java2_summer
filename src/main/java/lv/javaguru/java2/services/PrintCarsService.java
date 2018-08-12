package lv.javaguru.java2.services;

import lv.javaguru.java2.database.Database;
import lv.javaguru.java2.domain.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PrintCarsService {

    @Autowired
    private Database database;

    public List<Car> getCars() {
        return database.getAllCars();
    }

    public Car getCarById(long carId) {
        return database.getCarById(carId);
    }
}
