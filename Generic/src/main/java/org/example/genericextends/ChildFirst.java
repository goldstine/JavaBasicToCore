package org.example.genericextends;


public class ChildFirst<E,T,K> extends parent<E> {

//    public class ChildFirst<E> extends parent{}   //如果子类声明了泛型，父类要么默认为Object类类型，
//    否则必须和子类一致的泛型类型，即泛型符号相同
    @Override
    public E getValue(){
        return super.getValue();
    }
}
