package ru.job4j.collection;

import java.util.Objects;

public class Order {
    private String number;
    private String name;

    public Order(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(
                "Order{").append(
                        "number='").append(
                                number).append('\'').append(
                                        ", name='").append(name).append('\'').append(
                                                '}').toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this != o) {
            if (o != null && getClass() == o.getClass()) {
                Order order = (Order) o;
                return Objects.equals(name, order.name) && Objects.equals(number, order.number);
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name);
    }
}
