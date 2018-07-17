package lv.javaguru.java2.view;

import lv.javaguru.java2.services.ReturnCarService;

import static lv.javaguru.java2.utils.ConsoleUtils.getMenuItemFromConsole;

public class ReturnCarView implements ConsoleView {

    private ReturnCarService returnCarService;
    private PrintCarsView printCarsView;
    private PrintCustomerView printCustomerView;

    public ReturnCarView(ReturnCarService returnCarService, PrintCarsView printCarsView, PrintCustomerView printCustomerView) {
        this.returnCarService = returnCarService;
        this.printCarsView = printCarsView;
        this.printCustomerView = printCustomerView;
    }

    @Override
    public void execute() {
        System.out.println();
        System.out.println("Enter car id to return: ");
        Integer carId = getMenuItemFromConsole(true);
        boolean carIsRented = printCustomerView.carIsRented(carId);
        if (carIsRented) {
            returnCarService.returnCar(carId);
            printCarsView.printReturnedCarById(carId);
        }
        System.out.println();
    }
}
