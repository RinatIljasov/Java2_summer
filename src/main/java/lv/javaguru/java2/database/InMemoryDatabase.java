package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Car;
import lv.javaguru.java2.domain.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryDatabase implements Database {

    private ArrayList<Car> cars;
    private Customer customer;

    public InMemoryDatabase(Customer customer) {
        this.customer = customer;
        cars = initCarsList();
    }

    private static ArrayList<Car> initCarsList() {
        ArrayList<Car> carsList = new ArrayList<>();
        carsList.add(new Car(1, "Car1", 20));
        carsList.add(new Car(2, "Car2", 40));
        carsList.add(new Car(3, "Car3", 60));
        return carsList;
    }

    @Override
    public List<Car> getAllCars() {
        return new ArrayList<>(cars);
    }

    @Override
    public Car getCarById(Integer carId) {
        return getCar(carId);
    }

    @Override
    public void bookCar(Integer carId) {
        Car car = getCar(carId);
        if (car != null) {
            car.setRented(true);
            customer.dischargeMoney(car.getPrice());
        }
    }

    @Override
    public void returnCar(Integer carId) {
        Car car = getCar(carId);
        if (car != null) {
            car.setRented(false);
        }
    }

    @Override
    public double getCustomerBalance() {
        return customer.getMoney();
    }

    @Override
    public String getCustomerName() {
        return customer.getName();
    }

    @Override
    public boolean customerCanBook(Integer carId) {
        Car car = getCar(carId);
        if (car != null && customer.getMoney() >= car.getPrice()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean carIsBooked(Integer carId) {
        Car car = getCar(carId);
        if (car != null && car.isRented()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean carIsRented(Integer carId) {
        Car car = getCar(carId);
        if (car != null && car.isRented()) {
            return true;
        }
        return false;
    }

    private Car getCar(Integer carId) {
        Optional<Car> foundCar = cars.stream()
                .filter(c -> c.getId().equals(carId))
                .findFirst();
        return foundCar.orElse(null);
    }
}
