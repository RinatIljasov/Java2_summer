package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Customer;

public interface CustomerRepository {

    Customer getCustomerById(long customerId);

}
