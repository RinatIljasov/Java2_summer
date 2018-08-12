package lv.javaguru.java2.services;

public interface CarValidator {

    boolean checkIfCarCanBeReturned(long carId);

    boolean checkIfCarIsAlreadyBooked(long carId);

    boolean checkIfCustomerHasEnoughMoney(long carId, long customerId);

}
