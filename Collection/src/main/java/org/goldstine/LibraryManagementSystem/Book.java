package org.goldstine.LibraryManagementSystem;

public class Book {
    //书的类型不属于书的属性
    private String name;
    private double price;
    private String authorName;

    public Book() {
    }

    public Book(String name, double price, String authorName) {
        this.name = name;
        this.price = price;
        this.authorName = authorName;
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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
