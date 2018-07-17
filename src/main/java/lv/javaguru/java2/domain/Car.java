package lv.javaguru.java2.domain;

public class Car {
    private Integer id;
    private String name;
    private double price;
    private boolean rented;

    public Car(Integer id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    @Override
    public String toString() {
        return id + ", " + name + ", " + price + ", rented " + rented;
    }
}
