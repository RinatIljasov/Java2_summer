package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Car;
import lv.javaguru.java2.domain.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//@Component
public class JDBCDatabaseImpl extends JDBCRepository implements Database {

    public void addCustomer(Customer customer) {
        Connection connection = null;
        try {
            connection = getConnection();
//            String sql = "insert into customer(id, name, money) values( ?, ?, ?)";
//            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//            preparedStatement.setLong(1, 1);
//            preparedStatement.setString(2, customer.getFirstName());
//            preparedStatement.setDouble(3, customer.getMoney());
//
//            preparedStatement.executeUpdate();
//            ResultSet resultSet = preparedStatement.getGeneratedKeys();
//            if (resultSet.next()) {
//                customer.setId(resultSet.getLong(1));
//            }
        } catch (Throwable e) {
            System.out.println("Exception while execute CustomerDAOImpl.save()");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeConnnection(connection);
        }
    }

    public void addCar(Car car) {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "insert into car(id, name, price, rented) values( ?, ?, ?, 0)";
//            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//            preparedStatement.setLong(1, car.getId());
//            preparedStatement.setString(2, car.getFirstName());
//            preparedStatement.setDouble(3, car.getPrice());
//
//            preparedStatement.executeUpdate();
//            ResultSet resultSet = preparedStatement.getGeneratedKeys();
//            if (resultSet.next()) {
//                car.setId(resultSet.getLong(1));
//            }
        } catch (Throwable e) {
            System.out.println("Exception while execute CarDAOImpl.save()");
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            closeConnnection(connection);
        }
    }

    @Override
    public List<Car> getAllCars() {
        List<Car> lisrOfCars = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "select * from car";
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                Car newCar = new Car();
//                newCar.setId(resultSet.getLong("id"));
//                newCar.setName(resultSet.getString("name"));
//                newCar.setPrice(resultSet.getDouble("price"));
//                newCar.setRented(resultSet.getInt("rented") == 1);
//                lisrOfCars.add(newCar);
//            }
        } catch (Throwable e) {
            System.out.println("Exception while getting Cars list!");
            e.printStackTrace();
        } finally {
            closeConnnection(connection);
        }
        return lisrOfCars;
    }

    @Override
    public Car getCarById(long carId) {
        Car car = new Car();
        Connection connection = null;
        try {
            connection = getConnection();
            ResultSet resultSet = getCarByIdFromDB(connection, carId);
            while (resultSet.next()) {
                car.setId(resultSet.getLong("id"));
                car.setName(resultSet.getString("name"));
                car.setPrice(resultSet.getDouble("price"));
                //car.setRented(resultSet.getInt("rented") == 1);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting Car by id!");
            e.printStackTrace();
        } finally {
            closeConnnection(connection);
        }
        return car;
    }

    @Override
    public void bookCar(long carId, long customerId) {
        Connection connection = null;
        try {
            connection = getConnection();
            updateCarRentState(connection, carId, 1);

            double costomerAccount = getCustomerAccountById(connection, 1);
            double carPrice = getCarPriceById(connection, carId);

            updateCustomerAccount(connection, costomerAccount - carPrice, 1);
        } catch (Throwable e) {
            System.out.println("Exception while updating Customer by id!");
            e.printStackTrace();
        } finally {
            closeConnnection(connection);
        }
    }

    private double getCustomerAccountById(Connection connection, long customerId) throws Throwable {
        ResultSet resultSetCustomer = getCustomerByIdFromDB(connection, customerId);
        double customerAccount = 0;
        while (resultSetCustomer.next()) {
            customerAccount = resultSetCustomer.getDouble("money");
        }
        return customerAccount;
    }

    private double getCarPriceById(Connection connection, long carId) throws Throwable {
        ResultSet resultSetCar = getCarByIdFromDB(connection, carId);
        double carPrice = 0;
        while (resultSetCar.next()) {
            carPrice = resultSetCar.getDouble("price");
        }
        return carPrice;
    }

    @Override
    public void returnCar(long carId) {
        Connection connection = null;
        try {
            connection = getConnection();
            updateCarRentState(connection, carId, 0);
        } catch (Throwable e) {
            System.out.println("Exception while updating Car by id!");
            e.printStackTrace();
        } finally {
            closeConnnection(connection);
        }
    }

    @Override
    public double getCustomerBalance(long customerId) {
        double balance = 0;
        Connection connection = null;
        try {
            connection = getConnection();
            ResultSet resultSet = getCustomerByIdFromDB(connection, customerId);
            while (resultSet.next()) {
                balance = resultSet.getDouble("money");
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting Customer balance by id!");
            e.printStackTrace();
        } finally {
            closeConnnection(connection);
        }
        return balance;
    }

    @Override
    public String getCustomerName(long customerId) {
        String name = "";
        Connection connection = null;
        try {
            connection = getConnection();
            ResultSet resultSet = getCustomerByIdFromDB(connection, customerId);
            while (resultSet.next()) {
                name = resultSet.getString("name");
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting Customer name by id!");
            e.printStackTrace();
        } finally {
            closeConnnection(connection);
        }
        return name;
    }

    @Override
    public boolean customerCanBook(long carId, long customerId) {
        double carPrice = 1;
        double customersMoney = 0;
        Connection connection = null;
        try {
            connection = getConnection();

            ResultSet resultSetCar = getCarByIdFromDB(connection, carId);
            while (resultSetCar.next()) {
                carPrice = resultSetCar.getDouble("price");
            }

            ResultSet resultSetCustomer = getCustomerByIdFromDB(connection, customerId);
            while (resultSetCustomer.next()) {
                customersMoney = resultSetCustomer.getDouble("money");
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting Customer and Car price!");
            e.printStackTrace();
        } finally {
            closeConnnection(connection);
        }
        return customersMoney >= carPrice;
    }

    @Override
    public boolean carIsBooked(long carId) {
        boolean rented = false;
        Connection connection = null;
        try {
            connection = getConnection();
            ResultSet resultSet = getCarByIdFromDB(connection, carId);
            while (resultSet.next()) {
                rented = resultSet.getInt("rented") == 1;
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting Car book state!");
            e.printStackTrace();
        } finally {
            closeConnnection(connection);
        }
        return rented;
    }

    private ResultSet getCarByIdFromDB(Connection connection, long carId) throws Throwable {
//        String sql = "select * from car where id=?";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setLong(1, carId);
//        return preparedStatement.executeQuery();
        return null;
    }

    private ResultSet getCustomerByIdFromDB(Connection connection, long customerId) throws Throwable {
//        String sql = "select * from customer where id=?";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setLong(1, customerId);
//        return preparedStatement.executeQuery();
        return null;
    }

    private void updateCarRentState(Connection connection, long carId, Integer state) throws Throwable {
//        String sql = "update car set rented = ? where id = ?";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setInt(1, state);
//        preparedStatement.setLong(2, carId);
//        preparedStatement.executeUpdate();
    }

    private void updateCustomerAccount(Connection connection, double money, long customerId) throws Throwable {
//        String sql = "update customer set money = ? where id = ?";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setDouble(1, money);
//        preparedStatement.setLong(2, customerId);
//        preparedStatement.executeUpdate();
    }

}
