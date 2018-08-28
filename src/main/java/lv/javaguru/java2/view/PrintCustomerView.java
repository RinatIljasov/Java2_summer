package lv.javaguru.java2.view;

import lv.javaguru.java2.domain.Customer;
import lv.javaguru.java2.services.PrintCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrintCustomerView implements ConsoleView {

    @Autowired
    private PrintCustomerService printCustomerService;

    public void printCustomerBalance() {
        System.out.println("Customer Name: " + printCustomerService.getCustomerName(Customer.CUSTOMER_ID) + ", Customer Balance: " + printCustomerService.getCustomerBalance(Customer.CUSTOMER_ID) + " EUR");
        System.out.println();
    }

    @Override
    public void execute() {
        printCustomerBalance();
    }

}
