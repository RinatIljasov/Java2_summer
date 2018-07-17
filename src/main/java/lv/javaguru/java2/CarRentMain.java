package lv.javaguru.java2;

import lv.javaguru.java2.database.InMemoryDatabase;
import lv.javaguru.java2.domain.Customer;
import lv.javaguru.java2.services.BookCarService;
import lv.javaguru.java2.services.PrintCarsService;
import lv.javaguru.java2.services.PrintCustomerService;
import lv.javaguru.java2.services.ReturnCarService;
import lv.javaguru.java2.utils.ConsoleUtils;
import lv.javaguru.java2.view.BookCarView;
import lv.javaguru.java2.view.ConsoleView;
import lv.javaguru.java2.view.ExitView;
import lv.javaguru.java2.view.PrintCarsView;
import lv.javaguru.java2.view.PrintCustomerView;
import lv.javaguru.java2.view.ReturnCarView;

import java.util.HashMap;
import java.util.Map;

import static lv.javaguru.java2.utils.ConsoleUtils.getMenuItemFromConsole;

class CarRentMain {

    public static void main(String[] args) {
        Customer customer = new Customer("Rinat", 100);
        InMemoryDatabase database = new InMemoryDatabase(customer);

        BookCarService bookCarService = new BookCarService(database);
        ReturnCarService returnCarService = new ReturnCarService(database);
        PrintCarsService printCarsService = new PrintCarsService(database);
        PrintCustomerService printCustomerService = new PrintCustomerService(database);

        PrintCustomerView printCustomerView = new PrintCustomerView(printCustomerService);
        PrintCarsView printCarsView = new PrintCarsView(printCarsService);
        BookCarView bookCarView = new BookCarView(bookCarService, printCarsView, printCustomerView);
        ReturnCarView returnCarView = new ReturnCarView(returnCarService, printCarsView, printCustomerView);

        Map<Integer, ConsoleView> mapMenu = new HashMap<>();
        mapMenu.put(1, bookCarView);
        mapMenu.put(2, returnCarView);
        mapMenu.put(3, printCarsView);
        mapMenu.put(4, printCustomerView);
        mapMenu.put(5, new ExitView());

        ConsoleUtils.printProgramMenu();
        do {
            Integer menuItem = getMenuItemFromConsole(false);
            ConsoleView selectedMenuItem = mapMenu.get(menuItem);
            selectedMenuItem.execute();
        } while (true);
    }
}
