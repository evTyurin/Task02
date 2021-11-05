package by.tc.task01.entity;

import java.io.Serializable;
import java.util.Objects;

public abstract class Appliance implements Serializable {
    private String model;
    private double price;

    public Appliance() {};

    public Appliance(String model, double price) {
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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
        return Double.compare(appliance.price, price) == 0 && Objects.equals(model, appliance.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, price);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Appliance{").append("model='").append(model)
                    .append(", price=").append(price).append('}');

        return stringBuilder.toString();
    }
}
