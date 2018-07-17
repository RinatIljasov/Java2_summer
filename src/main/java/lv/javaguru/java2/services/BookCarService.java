package lv.javaguru.java2.services;

import lv.javaguru.java2.database.Database;

public class BookCarService {

    private Database database;

    public BookCarService(Database database) {
        this.database = database;
    }

    public void bookCar(Integer carId) {
        database.bookCar(carId);
    }

}
