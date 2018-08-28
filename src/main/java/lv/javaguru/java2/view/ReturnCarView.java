package lv.javaguru.java2.view;

import lv.javaguru.java2.services.ReturnCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static lv.javaguru.java2.utils.ConsoleUtils.getMenuItemFromConsole;

@Component
public class ReturnCarView implements ConsoleView {

    @Autowired
    private ReturnCarService returnCarService;
    @Autowired
    private PrintCarsView printCarsView;
    @Autowired
    private PrintCustomerView printCustomerView;

    @Override
    public void execute() {
        System.out.println();
        System.out.println("Enter car id to return: ");
        Integer carId = getMenuItemFromConsole(true);
        boolean carIsRented = returnCarService.checkIfCarCanBeReturned(carId.longValue());
        if (carIsRented) {
            returnCarService.returnCar(carId.longValue());
            printCarsView.printReturnedCarById(carId.longValue());
        }
        System.out.println();
    }
}
