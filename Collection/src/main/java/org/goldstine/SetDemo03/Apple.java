package org.goldstine.SetDemo03;

import java.util.Objects;

public class Apple {
    private String name;
    private double price;
    private String color;

    public Apple() {
    }

    public Apple(String name, double price, String color) {
        this.name = name;
        this.price = price;
        this.color = color;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }

    //只要两个对象的内容一样，equals为true
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apple apple = (Apple) o;
        return Double.compare(apple.price, price) == 0 &&
                Objects.equals(name, apple.name) &&
                Objects.equals(color, apple.color);
    }
    //只要两个对象的内容一样，返回的哈希值也一样，true
    @Override
    public int hashCode() {
        return Objects.hash(name, price, color);
    }
}
