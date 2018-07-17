package lv.javaguru.java2.domain;

public class Customer {
    private String name;
    private double money;

    public Customer(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public void dischargeMoney(double amountToDischarge) {
        money -= amountToDischarge;
    }
}
