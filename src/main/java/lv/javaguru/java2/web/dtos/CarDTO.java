package lv.javaguru.java2.web.dtos;

public class CarDTO {

    private long id;

    private String manufacturer;

    private double price;

    public CarDTO() {
    }

    public CarDTO(long id, String manufacturer, double price) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
