package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Car;
import lv.javaguru.java2.domain.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class ORMDatabaseDeprecatedImpl implements DatabaseDeprecated {

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

//    @Override
//    public List<Car> getAllCars() {
//        return session()
//                .createCriteria(Car.class)
//                .list();
//    }
//
//    @Override
//    public Car getCarById(long carId) {
//        return (Car) session()
//                .createCriteria(Car.class)
//                .add(Restrictions.eq("id", carId))
//                .uniqueResult();
//    }

//    @Override
//    public void bookCar(long carId, long customerId) {
//        Contract contract = new Contract(carId, customerId);
//        session().save(contract);
//        Customer customer = getCustomerById(customerId);
//        Car car = getCarById(carId);
//        customer.setBalance(customer.getBalance() - car.getPrice());
//        session().update(customer);
//    }

//    @Override
//    public void returnCar(long carId) {
//        Contract contract = getContractByCarId(carId);
//        contract.setExpired(true);
//        session().update(contract);
//    }

//    @Override
//    public double getCustomerBalance(long customerId) {
//        Customer customer = (Customer) session()
//                .createCriteria(Customer.class)
//                .add(Restrictions.eq("id", customerId))
//                .uniqueResult();
//        return customer.getBalance();
//    }

//    @Override
//    public String getCustomerName(long customerId) {
//        Customer customer = (Customer) session()
//                .createCriteria(Customer.class)
//                .add(Restrictions.eq("id", customerId))
//                .uniqueResult();
//        return customer.getFirstName() + ' ' + customer.getLastName();
//    }

//    @Override
//    public boolean customerCanBook(long carId, long customerId) {
//        Car car = getCarById(carId);
//        Customer customer = getCustomerById(customerId);
//        return customer.getBalance() >= car.getPrice();
//    }

//    @Override
//    public boolean carIsBooked(long carId) {
//        Contract contract = getContractByCarId(carId);
//        return contract != null && !contract.isExpired();
//    }

//    private Customer getCustomerById(Long customerId) {
//        return (Customer) session()
//                .createCriteria(Customer.class)
//                .add(Restrictions.eq("id", customerId))
//                .uniqueResult();
//    }
//
//    private Contract getContractByCarId(long carId) {
//        return (Contract) session()
//                .createCriteria(Contract.class)
//                .add(Restrictions.eq("carId", carId))
//                .add(Restrictions.eq("expired", false))
//                .uniqueResult();
//    }
}
