package org.example.genericinterface;

/**
 *泛型接口的实现类，是一个泛型类，那么保证实现接口的泛型类泛型标识包含泛型接口的泛型标识
 * @param <T>
 */
public class Pair<T,E> implements Generator<T>{
    private E value;
    private T t;

    public Pair() {

    }

    public Pair(E value, T t) {
        this.value = value;
        this.t = t;
    }

    @Override
    public T getKey() {
        return t;
    }
}
