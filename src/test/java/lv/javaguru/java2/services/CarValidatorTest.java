package lv.javaguru.java2.services;

import lv.javaguru.java2.database.Database;
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
    private Database database;

    @InjectMocks
    private CarValidatorImpl validator;

    @Test
    public void checkIfCarCanBeReturnedIfAlreadyBooked() {
        Mockito.when(database.carIsBooked(DEFAULT_CAR_ID)).thenReturn(true);
        boolean result = validator.checkIfCarCanBeReturned(DEFAULT_CAR_ID);
        assertTrue(result);
    }

    @Test
    public void checkIfCarCanBeReturnedIfNotBooked() {
        Mockito.when(database.carIsBooked(DEFAULT_CAR_ID)).thenReturn(false);
        boolean result = validator.checkIfCarCanBeReturned(DEFAULT_CAR_ID);
        assertFalse(result);
    }

    @Test
    public void checkIfCarIsAlreadyBooked() {
        Mockito.when(database.carIsBooked(DEFAULT_CAR_ID)).thenReturn(true);
        boolean result = validator.checkIfCarIsAlreadyBooked(DEFAULT_CAR_ID);
        assertTrue(result);
    }

    @Test
    public void checkIfCarIsNotAlreadyBooked() {
        Mockito.when(database.carIsBooked(DEFAULT_CAR_ID)).thenReturn(false);
        boolean result = validator.checkIfCarIsAlreadyBooked(DEFAULT_CAR_ID);
        assertFalse(result);
    }

    @Test
    public void checkIfCustomerHasEnoughMoney() {
        Mockito.when(database.customerCanBook(DEFAULT_CAR_ID, DEFAULT_CUSTOMER_ID)).thenReturn(true);
        boolean result = validator.checkIfCustomerHasEnoughMoney(DEFAULT_CAR_ID, DEFAULT_CUSTOMER_ID);
        assertTrue(result);
    }

    @Test
    public void checkIfCustomerHasNotEnoughMoney() {
        Mockito.when(database.customerCanBook(DEFAULT_CAR_ID, DEFAULT_CUSTOMER_ID)).thenReturn(false);
        boolean result = validator.checkIfCustomerHasEnoughMoney(DEFAULT_CAR_ID, DEFAULT_CUSTOMER_ID);
        assertFalse(result);
    }
}
