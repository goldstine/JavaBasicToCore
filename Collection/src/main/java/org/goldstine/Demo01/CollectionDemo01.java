package org.goldstine.Demo01;

import java.util.*;

/**
 * Collection集合概述
 *      什么是集合？
 *          集合是一个大小可变的容器
 *              容器中的每一个数据称为一个元素，数据==元素
 *              集合的特点：类型可以不确定，大小不固定。集合有很多种，不同的集合特点和使用场景不同
 *              数组：类型长度一旦定义出来就都固定了
 *      java中集合的代表是：Collection
 *          Collection集合是java中集合的祖宗类
 *
 *        集合的特点：
 *              Set系列集合：添加的元素是无序的，不重复，无索引的
 *                  ---HashSet:添加的元素是无序，不重复，无索引的
 *                  ---LinkedHashSet:添加的元素是有序的，不重复，无索引的
 *                  ----TreeSet:按照大小默认升序排列
 *             List系列： 添加的元素是有序的，可重复，有索引的
 *                  ---ArrayList:添加的元素是有序，可重复，有索引
 *                  ---LinkedList:添加的元素是有序，可重复，有索引
 *
 *            Collection是集合的祖宗类，Collection集合的功能时一切集合都可以直接使用的
 *
 * Collection集合的api如下所示：
 *      public boolean add(E e);  把给定的对象添加到当前集合中
 *      public void clear();清空集合中所有的元素
 *      public boolean remove(E e);把给定的对象在当前集合删除
 *      public boolean contains(Object obj);判断当前集合中是否包含给定对象
 *      public boolean isEmpty();判断当前集合是否为空
 *      public int size();返回集合中元素的个数
 *      public Object[] toArray();把集合中的元素存储到数组中
 *
 *
 */
public class CollectionDemo01 {

    public static void main(String[] args) {
        Collection<String> sets = new HashSet<>();//无序，无索引，不重复
        sets.add("Mybatis");
        sets.add("java");
        sets.add("java");
        sets.add("spring");
        sets.add("mysql");
        System.out.println(sets);

        Collection<String> lists=new ArrayList<>(); //有序，有索引，可重复
        lists.add("mysql");
        lists.add("java");
        lists.add("java");
        lists.add("spring");
        lists.add("mysql");

        System.out.println(lists);

        //Collection api
        Collection<String> obj = new HashSet<>();//重构的快捷键  shift+F6
        System.out.println(obj.add("贾乃亮"));
        System.out.println(obj.add("贾乃亮"));
        System.out.println(obj.add("王宝强"));
        System.out.println(obj.add("陈羽凡"));

        System.out.println(obj); //集合重写了toString()，默认打印出集合内容
        //清空所有元素
//        obj.clear();
//
//        System.out.println(obj);

        //判断集合是否为空
        System.out.println(obj.isEmpty());
        //判断集合的大小
        System.out.println(obj.size());

        //删除指定的元素
        System.out.println(obj.remove("王宝强"));

        System.out.println(obj);

        //判断是否包含指定元素
        System.out.println(obj.contains("陈羽凡"));

        //将集合转为数组
        Object [] objects = obj.toArray();
        System.out.println(objects);
        //查看数组元素
        System.out.println("数组："+ Arrays.toString(objects));

        //将Object类型的数组转为指定数据类型的数组
//        String[] arrs1=obj.toArray(String[]::new);

        Collection<String> obj1=new ArrayList<>();
        obj1.add("李小璐");
        obj1.add("马蓉");

        Collection<String> obj2=new ArrayList<>();
        obj2.add("白百合");

        //将obj2中的元素全部加入obj1中
        obj1.addAll(obj2);
        System.out.println(obj1);

        System.out.println(obj2);//但是原来的obj2还是有原来的元素，所以addAll()相当于集合拷贝


    }
}
