package lv.javaguru.java2.utils;

import java.util.Scanner;

public class ConsoleUtils {

    public static Integer getMenuItemFromConsole(boolean isSilent) {
        if (!isSilent) {
            System.out.print("Please enter menu item number to execute:");
        }
        Scanner sc = new Scanner(System.in);
        return Integer.parseInt(sc.next());
    }

    public static void printProgramMenu() {
        System.out.println("Program Menu:");
        System.out.println("1. Select car for rent");
        System.out.println("2. Return rented car");
        System.out.println("3. Print all cars");
        System.out.println("4. Print customer balance");
        System.out.println("5. Exit");
        System.out.println();
    }
}
