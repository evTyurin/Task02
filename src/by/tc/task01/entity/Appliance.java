package by.tc.task01.entity;

import java.io.Serializable;
import java.util.Objects;

public abstract class Appliance implements Serializable {
    private String model;
    private String type;
    private double price;

    public Appliance () {};

    public Appliance (String model, String type, double price) {
        this.model = model;
        this.type = type;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Appliance)) return false;
        Appliance appliance = (Appliance) o;
        return Double.compare(appliance.price, price) == 0 && Objects.equals(model, appliance.model) && Objects.equals(type, appliance.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, type, price);
    }

    @Override
    public String toString() {
        return "Appliance{" +
                "model='" + model + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}
