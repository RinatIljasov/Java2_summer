package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Car;

import java.util.List;
import java.util.Optional;

public interface Database {

    List<Car> getAllCars();

    Car getCarById(Integer carId);

    void bookCar(Integer carId);

    void returnCar(Integer carId);

    double getCustomerBalance();

    String getCustomerName();

    boolean customerCanBook(Integer carId);

    boolean carIsBooked(Integer carId);

    boolean carIsRented(Integer carId);
}
