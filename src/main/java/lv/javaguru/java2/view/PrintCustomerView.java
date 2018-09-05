package lv.javaguru.java2.view;

import lv.javaguru.java2.businesslogic.printcustomer.PrintCustomerService;
import lv.javaguru.java2.domain.Customer;
import lv.javaguru.java2.view.ConsoleView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrintCustomerView implements ConsoleView {

    @Autowired
    private PrintCustomerService printCustomerService;

    public void printCustomerBalance() {
        Customer customer   = printCustomerService.getCustomerById(Customer.CUSTOMER_ID);
        System.out.println("Customer Name: " + customer.getFirstName() + " " + customer.getLastName() + ", Customer Balance: " + customer.getBalance() + " EUR");
        System.out.println();
    }

    @Override
    public void execute() {
        printCustomerBalance();
    }

}
