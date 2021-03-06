package org.goldstine.cardAPP;

public class CardMap {
    private String number;
    private String color;

    public CardMap() {
    }

    public CardMap(String number, String color) {
        this.number = number;
        this.color = color;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return number+color;
    }
}
