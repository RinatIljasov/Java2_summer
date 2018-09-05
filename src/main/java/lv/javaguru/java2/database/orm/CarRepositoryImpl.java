package lv.javaguru.java2.database.orm;

import lv.javaguru.java2.database.CarRepository;
import lv.javaguru.java2.domain.Car;
import lv.javaguru.java2.domain.Contract;
import lv.javaguru.java2.domain.Customer;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarRepositoryImpl extends ORMRepository implements CarRepository {
    @Override
    public List getAllCars() {
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
    public void bookCar(Long carId, Long customerId) {
        Contract contract = new Contract(carId, customerId);
        session().save(contract);
        Customer customer = getCustomerById(customerId);
        Car car = getCarById(carId);
        customer.setBalance(customer.getBalance() - car.getPrice());
        session().update(customer);
    }

    @Override
    public void returnCar(long carId) {
        Contract contract = getContractByCarId(carId);
        contract.setExpired(true);
        session().update(contract);
    }

    @Override
    public boolean carIsBooked(long carId) {
        Contract contract = getContractByCarId(carId);
        return contract != null && !contract.isExpired();
    }

    @Override
    public boolean customerCanBook(long carId, long customerId) {
        Car car = getCarById(carId);
        Customer customer = getCustomerById(customerId);
        return customer.getBalance() >= car.getPrice();
    }

    private Contract getContractByCarId(long carId) {
        return (Contract) session()
                .createCriteria(Contract.class)
                .add(Restrictions.eq("carId", carId))
                .add(Restrictions.eq("expired", false))
                .uniqueResult();
    }

    private Customer getCustomerById(Long customerId) {
        return (Customer) session()
                .createCriteria(Customer.class)
                .add(Restrictions.eq("id", customerId))
                .uniqueResult();
    }

}
