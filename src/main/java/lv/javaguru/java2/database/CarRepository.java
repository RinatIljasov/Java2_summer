package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Car;

import java.util.List;

public interface CarRepository {

    List getAllCars();

    Car getCarById(Long carId);

    void bookCar(Long carId, Long customerId);

    void returnCar(Long carId);

    boolean carIsBooked(long carId);

    boolean customerCanBook(long carId, long customerId);

}
