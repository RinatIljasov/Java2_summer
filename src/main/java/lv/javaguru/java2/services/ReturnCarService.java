package lv.javaguru.java2.services;

import lv.javaguru.java2.database.Database;

public class ReturnCarService {

    private Database database;

    public ReturnCarService(Database database) {
        this.database = database;
    }

    public void returnCar(Integer carId) {
        database.returnCar(carId);
    }
}
