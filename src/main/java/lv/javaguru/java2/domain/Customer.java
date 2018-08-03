package lv.javaguru.java2.domain;

public class Customer {
    private String name;
    private double money;
    private long id;

    public Customer(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void dischargeMoney(double amountToDischarge) {
        money -= amountToDischarge;
    }
}
