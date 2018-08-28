package lv.javaguru.java2.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "manufacturer", nullable = false)
    private String manufacturer;

    @Column(name = "price", nullable = false)
    private double price;


    public Car(Integer id, String manufacturer, double price) {
        this.id = id;
        this.manufacturer = manufacturer;
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
        return manufacturer;
    }

    public void setName(String name) {
        this.manufacturer = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Car Id: " + id + ", Car Name: " + manufacturer + ", Car Price: " + price + " EUR";
    }
}
