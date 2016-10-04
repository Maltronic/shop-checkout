package io.maltronic.checkout.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product implements Cloneable {

    public static final String TYPE_APPLE = "Apple";
    public static final String TYPE_ORANGE = "Orange";

    private final int id;
    private final String name;
    private final double price;
    private final boolean active;

    public Product(int id, String name, double price, boolean active) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.active = active;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public double getPrice() {
        return price;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public Product clone() {
        try {
            return (Product) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (Double.compare(product.price, price) != 0) return false;
        if (active != product.active) return false;
        return name != null ? name.equals(product.name) : product.name == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (active ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", active=" + active +
                '}';
    }
}
