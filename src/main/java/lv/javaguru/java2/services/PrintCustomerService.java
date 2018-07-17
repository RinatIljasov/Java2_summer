package lv.javaguru.java2.services;

import lv.javaguru.java2.database.Database;

public class PrintCustomerService {
    private Database database;

    public PrintCustomerService(Database database) {
        this.database = database;
    }

    public double getCustomerBalance() {
        return database.getCustomerBalance();
    }

    public String getCustomerName() {
        return database.getCustomerName();
    }

    public boolean customerCanBook(Integer carId) {
        return database.customerCanBook(carId);
    }

    public boolean carIsBooked(Integer carId) {
        return database.carIsBooked(carId);
    }
}
