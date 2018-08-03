package lv.javaguru.java2.services;

import lv.javaguru.java2.database.Database;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class PrintCustomerServiceTest {

    public static final long DEFAULT_CUSTOMER_ID = 1L;

    @Mock
    private Database database;

    @Test
    public void checkIfCanGetCustomerName() {
        Mockito.when(database.getCustomerName(DEFAULT_CUSTOMER_ID)).thenReturn("Rinat");
        String customerName = database.getCustomerName(DEFAULT_CUSTOMER_ID);
        assertEquals(customerName, "Rinat");
    }

    @Test
    public void checkIfCanbotGetCustomerName() {
        Mockito.when(database.getCustomerName(DEFAULT_CUSTOMER_ID)).thenReturn("");
        String customerName = database.getCustomerName(DEFAULT_CUSTOMER_ID);
        assertEquals(customerName, "");
    }

    @Test
    public void checkIfCanGetCustomerBalance() {
        Mockito.when(database.getCustomerBalance(DEFAULT_CUSTOMER_ID)).thenReturn(100.0);
        double customerBalance = database.getCustomerBalance(DEFAULT_CUSTOMER_ID);
        assertEquals(customerBalance, 100.0, 0.001);
    }

    @Test
    public void checkIfCannotGetCustomerBalance() {
        Mockito.when(database.getCustomerBalance(DEFAULT_CUSTOMER_ID)).thenReturn(0.0);
        double customerBalance = database.getCustomerBalance(DEFAULT_CUSTOMER_ID);
        assertEquals(customerBalance, 0.0, 0.001);
    }
}
