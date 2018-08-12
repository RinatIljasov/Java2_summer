package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Car;
import lv.javaguru.java2.domain.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class ORMDatabaseImpl implements Database {

    @Autowired
    private SessionFactory sessionFactory;

    private Session session() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addCustomer(Customer customer) {
        session().save(customer);
    }

    @Override
    public void addCar(Car car) {
        session().save(car);
    }

    @Override
    public List<Car> getAllCars() {
        return session()
                .createCriteria(Car.class)
                .list();
    }

    @Override
    public Car getCarById(long carId) {
        return (Car) session()
                .createCriteria(Car.class)
                .add(Restrictions.eq("id", carId))
                .uniqueResult();
    }

    @Override
    public void bookCar(long carId, long customerId) {
        Car car = getCarById(carId);
        car.setRented(true);
        session().update(car);
        Customer customer = getCustomerById(customerId);
        customer.setMoney(customer.getMoney() - car.getPrice());
        session().update(customer);
    }

    @Override
    public void returnCar(long carId) {
        Car car = getCarById(carId);
        car.setRented(false);
        session().update(car);
    }

    @Override
    public double getCustomerBalance(long customerId) {
        Customer customer = (Customer) session()
                .createCriteria(Customer.class)
                .add(Restrictions.eq("id", customerId))
                .uniqueResult();
        return customer.getMoney();
    }

    @Override
    public String getCustomerName(long customerId) {
        Customer customer = (Customer) session()
                .createCriteria(Customer.class)
                .add(Restrictions.eq("id", customerId))
                .uniqueResult();
        return customer.getName();
    }

    @Override
    public boolean customerCanBook(long carId, long customerId) {
        Car car = getCarById(carId);
        Customer customer = getCustomerById(customerId);
        return customer.getMoney() >= car.getPrice();
    }

    @Override
    public boolean carIsBooked(long carId) {
        Car car = getCarById(carId);
        return car.isRented();
    }

    private Customer getCustomerById(Long customerId) {
        return (Customer) session()
                .createCriteria(Customer.class)
                .add(Restrictions.eq("id", customerId))
                .uniqueResult();
    }
}
