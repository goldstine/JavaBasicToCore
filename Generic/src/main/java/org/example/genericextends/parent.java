package org.example.genericextends;

public class parent<E> {
    private E value;

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }
}
