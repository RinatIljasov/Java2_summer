package lv.javaguru.java2.domain;

public class Car {
    private long id;
    private String name;
    private double price;
    private boolean rented;

    public Car(Integer id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Car() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
