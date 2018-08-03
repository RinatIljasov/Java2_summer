package lv.javaguru.java2;

import lv.javaguru.java2.config.SpringAppConfig;
import lv.javaguru.java2.utils.ConsoleUtils;
import lv.javaguru.java2.view.BookCarView;
import lv.javaguru.java2.view.ConsoleView;
import lv.javaguru.java2.view.ExitView;
import lv.javaguru.java2.view.PrintCarsView;
import lv.javaguru.java2.view.PrintCustomerView;
import lv.javaguru.java2.view.ReturnCarView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.Map;

import static lv.javaguru.java2.utils.ConsoleUtils.getMenuItemFromConsole;

class CarRentMain {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringAppConfig.class);

        Map<Integer, ConsoleView> mapMenu = new HashMap<>();
        mapMenu.put(1, context.getBean(BookCarView.class));
        mapMenu.put(2, context.getBean(ReturnCarView.class));
        mapMenu.put(3, context.getBean(PrintCarsView.class));
        mapMenu.put(4, context.getBean(PrintCustomerView.class));
        mapMenu.put(5, new ExitView());

        ConsoleUtils.printProgramMenu();
        do {
            Integer menuItem = getMenuItemFromConsole(false);
            ConsoleView selectedMenuItem = mapMenu.get(menuItem);
            selectedMenuItem.execute();
        } while (true);
    }
}
