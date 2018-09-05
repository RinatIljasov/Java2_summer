package lv.javaguru.java2.services;

import lv.javaguru.java2.database.orm.CustomerRepositoryImlp;
import lv.javaguru.java2.domain.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.Silent.class)
public class PrintCustomerServiceTest {

    public static final long DEFAULT_CUSTOMER_ID = 1L;

    @Mock
    private CustomerRepositoryImlp customerRepository;

    private Customer customer;
    private Customer customerDummy;

    @Before
    public void init() {
        customer = new Customer("Rinat", "", 100.0);
        customerDummy = new Customer("", "", 0.0);
    }

    @Test
    public void checkIfCanGetCustomerName() {
        Mockito.when(customerRepository.getCustomerById(DEFAULT_CUSTOMER_ID)).thenReturn(customer);
        String customerName = customer.getFirstName();
        assertEquals(customerName, "Rinat");
    }

    @Test
    public void checkIfCannotGetCustomerName() {
        Mockito.when(customerRepository.getCustomerById(DEFAULT_CUSTOMER_ID)).thenReturn(customerDummy);
        String customerName = customerDummy.getFirstName();
        assertEquals(customerName, "");
    }

    @Test
    public void checkIfCanGetCustomerBalance() {
        Mockito.when(customerRepository.getCustomerById(DEFAULT_CUSTOMER_ID)).thenReturn(customer);
        double customerBalance = customer.getBalance();
        assertEquals(customerBalance, 100.0, 0.001);
    }

    @Test
    public void checkIfCannotGetCustomerBalance() {
        Mockito.when(customerRepository.getCustomerById(DEFAULT_CUSTOMER_ID)).thenReturn(customerDummy);
        double customerBalance = customerDummy.getBalance();
        assertEquals(customerBalance, 0.0, 0.001);
    }
}
