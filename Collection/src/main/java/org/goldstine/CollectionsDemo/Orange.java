package org.goldstine.CollectionsDemo;

public class Orange implements Comparable<Orange>{
    private String name;
    private double weight;
    private String price;

    public Orange() {
    }

    public Orange(String name, double weight, String price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Orange{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", price='" + price + '\'' +
                '}';
    }

    @Override
    public int compareTo(Orange o) {
        if(this.weight>o.weight){
            return 1;
        }else if(this.weight<o.weight){
            return -1;
        }
        return 0;
    }
}
