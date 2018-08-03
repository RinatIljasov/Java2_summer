package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Car;
import lv.javaguru.java2.domain.Customer;

import java.util.List;

public interface Database {

    void addCustomer(Customer customer);

    void addCar(Car car);

    List<Car> getAllCars();

    Car getCarById(Long carId);

    void bookCar(Long carId);

    void returnCar(Long carId);

    double getCustomerBalance(Long customerId);

    String getCustomerName(Long customerId);

    boolean customerCanBook(Long carId, Long customerId);

    boolean carIsBooked(Long carId);
}
