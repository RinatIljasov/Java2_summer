package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Car;
import lv.javaguru.java2.domain.Customer;

import java.util.List;

public interface Database {

    void addCustomer(Customer customer);

    void addCar(Car car);

    List getAllCars();

    Car getCarById(long carId);

    void bookCar(long carId, long customerId);

    void returnCar(long carId);

    double getCustomerBalance(long customerId);

    String getCustomerName(long customerId);

    boolean customerCanBook(long carId, long customerId);

    boolean carIsBooked(long carId);
}
