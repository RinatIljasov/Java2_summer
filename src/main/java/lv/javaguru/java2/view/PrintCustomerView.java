package lv.javaguru.java2.view;

import lv.javaguru.java2.services.PrintCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrintCustomerView implements ConsoleView {

    @Autowired
    private PrintCustomerService printCustomerService;

    public void printCustomerBalance() {
        System.out.println("Customer " + printCustomerService.getCustomerName(1L) + " balance: " + printCustomerService.getCustomerBalance(1L) + "EUR");
        System.out.println();
    }

    @Override
    public void execute() {
        printCustomerBalance();
    }

}
