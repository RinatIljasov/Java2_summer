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
    public void addCustomer(Customer customer) {

    }

    @Override
    public void addCar(Car car) {

    }

    @Override
    public List<Car> getAllCars() {
        return new ArrayList<>(cars);
    }

    @Override
    public Car getCarById(Long carId) {
        return getCar(carId);
    }

    @Override
    public void bookCar(Long carId) {
        Car car = getCar(carId);
        if (car != null) {
            car.setRented(true);
            customer.dischargeMoney(car.getPrice());
        }
    }

    @Override
    public void returnCar(Long carId) {
        Car car = getCar(carId);
        if (car != null) {
            car.setRented(false);
        }
    }

    @Override
    public double getCustomerBalance(Long customerId) {
        return customer.getMoney();
    }

    @Override
    public String getCustomerName(Long customerId) {
        return customer.getName();
    }

    @Override
    public boolean customerCanBook(Long carId, Long customerId) {
        Car car = getCar(carId);
        return car != null && customer.getMoney() >= car.getPrice();
    }

    @Override
    public boolean carIsBooked(Long carId) {
        Car car = getCar(carId);
        return car != null && car.isRented();
    }

    private Car getCar(Long carId) {
        Optional<Car> foundCar = cars.stream()
                .filter(c -> c.getId() == carId)
                .findFirst();
        return foundCar.orElse(null);
    }
}
