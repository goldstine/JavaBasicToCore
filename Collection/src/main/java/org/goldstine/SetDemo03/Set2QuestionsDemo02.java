package org.goldstine.SetDemo03;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 关于Set集合的两个问题：
 *      （1）Set集合添加的元素是不重复的，底层是如何去重复的
 *      （2）Set集合元素无序的原因是什么
 *
 * //在java中每一个对象都有hashCode(),该方法属于Object类的方法  同equals()  toString()
 *      Set去重：
 *            (2)对于有值特性的，Set集合可以直接判断进行去重复
 *          （2）对于引用数据类型的数据对象，Set集合是按照如下流程进行是否重复的判断
 *              Set集合会让两两对象调用自己的hashCode()得到彼此的hash值（所谓的内存地址）
 *              然后比较两个对象的hash值是否相同，如果不相同则直接认为两个对象不重复
 *              如果hash值相同，会继续让两个对象进行equals比较内容是否相同，如果还相同则认为真的是重复了
 *              如果不相同认为不重复
 *
 * 小结：
 * 如果希望Set集合认为两个对象只要内容一样就重复了，必须重写对象的hashCode和equals方法
 *
 *  Set集合添加元素无序的根本原因是因为底层采用了哈希表存储元素
 *      因为hash存储方式：作为一种将数组和链表进行结合的存储方式，性能比较好，增删改查的性能都比较好
 *      JDK1.8之前：hash表=数组+链表+【hash算法】
 *      jdk1.8之后：hash表=数组+链表+红黑树+【hash算法】
 *      之所以采用红黑树的原因，是因为如果链表过长，容易导致性能低，所以当链表长度过长之后，将对应的链表转为红黑树存储
 *  当链表的长度超过阈值（8）时，将链表转换为红黑树，这样大大减少了查询时间
 *
 * 实际上HashSet的底层是基于HashMap的
 *HashSet的每一个存储元素都是node节点：每一个Node节点：
 *
 * 小结：
 *      Set系列集合是基于哈希表存储数据的
 *      他的增删改查的性能都比较好，但是它是无需不重复的，如果不在意当然可以使用
 *
 *
 * LinkedHashSet:是HashSet的子类，元素是有序，不重复，无索引
 *      LinkedHashSet底层依然是使用hash表存储元素的
 *      但是每个元素都额外带一个链来维护添加顺序
 *不光增删查快，还有序，缺点是多一个存储顺序的链会占内存空间，并且不允许重复，无索引
 *
 * 总结：
 * （1）如果希望元素可以重复，又有索引，查询要快用ArrayList集合（用的最多）
 * （2）如果希望元素可以重复，又有索引，增删要快要用LinkedList集合
 * （3）如果希望增删改查都很快，但是元素不重复以及无序无索引，用HashSet
 *(4)如果希望增删改查都很快且有序，但是元素不重复以及无索引，那么用LinkedHashSet集合
 *
 *
 */
public class Set2QuestionsDemo02 {
    public static void main(String[] args) {
        Set<Integer> sets = new HashSet<Integer>();
        sets.add(1);
        sets.add(2);
        sets.add(3);
        sets.add(4);

        System.out.println(sets);

        //存储一些自定义数据类型
        Set<Apple> apples = new HashSet<>();
        Apple a1 = new Apple("红富士", 12.1, "红色");
        Apple a2 = new Apple("阿克苏", 39.9, "青红色");
        Apple a3 = new Apple("阿克苏", 39.9, "青红色");

        //哈希值，相当于是内存地址，实际可能不是内存地址，不同对象的hash值不同，相同对象的hash值相同
        //hashCode()返回值是int类型
        System.out.println(a1.hashCode());
        System.out.println(a2.hashCode());
        System.out.println(a3.hashCode());

        apples.add(a1);
        apples.add(a2);
        apples.add(a3);
        System.out.println(apples);
//[Apple{name='阿克苏', price=39.9, color='青红色'}, Apple{name='阿克苏', price=39.9, color='青红色'}, Apple{name='红富士', price=12.1, color='红色'}]
        //两个对象的内容相同，但是对应的集合判断为不重复


        //通过LinkedHashSet保证添加数据的有序性，通过每一个元素增加一个链来保证有序，底层依旧使用hash存储
        //就和名字一样
        LinkedHashSet<String> integers = new LinkedHashSet<>();
        integers.add("java1");
        integers.add("java2");
        integers.add("mybatis");
        System.out.println(integers);

    }
}
