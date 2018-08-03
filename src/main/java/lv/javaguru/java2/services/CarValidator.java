package lv.javaguru.java2.services;

import java.util.List;

public interface CarValidator {

    boolean checkIfCarCanBeReturned(long carId);

    boolean checkIfCarIsAlreadyBooked(Long carId);

    boolean checkIfCustomerHasEnoughMoney(long carId, long customerId);

}
