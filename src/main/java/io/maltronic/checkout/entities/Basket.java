package io.maltronic.checkout.entities;

import java.util.List;

public class Basket {
    private final int id;
    private final List<Product> items;

    public Basket(int id, List<Product> items) {
        this.id = id;
        this.items = items;
    }

    public double getTotal() {
        return items.stream().mapToDouble(Product::getPrice).sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Basket basket = (Basket) o;

        if (id != basket.id) return false;
        return items != null ? items.equals(basket.items) : basket.items == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (items != null ? items.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "id=" + id +
                ", items=" + items +
                '}';
    }
}
