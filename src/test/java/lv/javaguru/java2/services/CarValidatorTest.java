package lv.javaguru.java2.services;

import lv.javaguru.java2.businesslogic.CarValidatorImpl;
import lv.javaguru.java2.database.orm.CarRepositoryImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class CarValidatorTest {

    public static final long DEFAULT_CAR_ID = 1L;
    public static final long DEFAULT_CUSTOMER_ID = 1L;
    @Mock
    private CarRepositoryImpl carRepository;

    @InjectMocks
    private CarValidatorImpl validator;

    @Test
    public void checkIfCarCanBeReturnedIfAlreadyBooked() {
        Mockito.when(carRepository.carIsBooked(DEFAULT_CAR_ID)).thenReturn(true);
        boolean result = validator.checkIfCarCanBeReturned(DEFAULT_CAR_ID);
        assertTrue(result);
    }

    @Test
    public void checkIfCarCanBeReturnedIfNotBooked() {
        Mockito.when(carRepository.carIsBooked(DEFAULT_CAR_ID)).thenReturn(false);
        boolean result = validator.checkIfCarCanBeReturned(DEFAULT_CAR_ID);
        assertFalse(result);
    }

    @Test
    public void checkIfCarIsAlreadyBooked() {
        Mockito.when(carRepository.carIsBooked(DEFAULT_CAR_ID)).thenReturn(true);
        boolean result = validator.checkIfCarIsAlreadyBooked(DEFAULT_CAR_ID);
        assertTrue(result);
    }

    @Test
    public void checkIfCarIsNotAlreadyBooked() {
        Mockito.when(carRepository.carIsBooked(DEFAULT_CAR_ID)).thenReturn(false);
        boolean result = validator.checkIfCarIsAlreadyBooked(DEFAULT_CAR_ID);
        assertFalse(result);
    }

    @Test
    public void checkIfCustomerHasEnoughMoney() {
        Mockito.when(carRepository.customerCanBook(DEFAULT_CAR_ID, DEFAULT_CUSTOMER_ID)).thenReturn(true);
        boolean result = validator.checkIfCustomerHasEnoughMoney(DEFAULT_CAR_ID, DEFAULT_CUSTOMER_ID);
        assertTrue(result);
    }

    @Test
    public void checkIfCustomerHasNotEnoughMoney() {
        Mockito.when(carRepository.customerCanBook(DEFAULT_CAR_ID, DEFAULT_CUSTOMER_ID)).thenReturn(false);
        boolean result = validator.checkIfCustomerHasEnoughMoney(DEFAULT_CAR_ID, DEFAULT_CUSTOMER_ID);
        assertFalse(result);
    }
}
