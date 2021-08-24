package org.example.genericinterface;

/**
 * 如果实现泛型接口的类，不是泛型类，需要明确指定实现接口的泛型数据类型
 */
public class Apple implements Generator<String>{
    @Override
    public String getKey() {
        return "goldstine";
    }
//    @Override
//    public Object getKey() {//如果接口没有指明泛型的类型，默认就是Object类型
//        return null;
//    }
}
