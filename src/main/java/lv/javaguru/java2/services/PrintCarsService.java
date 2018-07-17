package lv.javaguru.java2.services;

import lv.javaguru.java2.database.Database;
import lv.javaguru.java2.domain.Car;

import java.util.List;

public class PrintCarsService {

    private Database database;

    public PrintCarsService(Database database) {
        this.database = database;
    }

    public List<Car> getCars() {
        return database.getAllCars();
    }

    public Car getCarById(Integer carId) {
        return database.getCarById(carId);
    }
}
