package lv.javaguru.java2.services;

import lv.javaguru.java2.database.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrintCustomerService {

    @Autowired
    private Database database;

    public double getCustomerBalance(Long customerId) {
        return database.getCustomerBalance(customerId);
    }

    public String getCustomerName(Long customerId) {
        return database.getCustomerName(customerId);
    }

}
