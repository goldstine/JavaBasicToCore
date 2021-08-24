package org.example;

/**
 * 泛型类的定义
 * @param <T> 泛型表示--类型形参
 *           创建对象的时候制定具体的数据类型
 */
public class Generic<T> {
//使用
    private T key;

    public Generic(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }


}
