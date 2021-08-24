package org.goldstine.ListDemo02;

import java.util.LinkedList;

/**
 * LinkedList也是List实现类，底层是基于链表的，增删比较快，查询慢
 * LinkedList是支持双链表，定位前后的元素是非常快的，增删前后的元素也是最快的
 * 所以LinkedList除了拥有List集合的全部功能还多了很多操作首尾元素的特殊功能
 *          public void addFirst(E e);将指定元素插入此列表的开头
 *          public void addLast(E e);将指定元素添加到此列表的结尾
 *          public E getFirst();返回此列表的第一个元素
 *          public E getLast();返回此列表的最后一个元素
 *          public E removeFirst();移除并返回此列表的第一个元素
 *          public E removeLast(); //移除并返回此列表的最后一个元素
 *          public E pop();从此列表所表示的堆栈处弹出一个元素
 *          public void push(E e);将元素推入此列表所表示的堆栈
 *
 * 小结：
 *      LinkedList是支持双链表，定位前后元素是非常快的，增删首尾元素也是最快的
 *      所以提供了很多操作首位api可以做栈和队列的
 *
 *      如果查询多，增删少，用ArrayList
 *      如果查询少，首尾增删多建议使用LinkedList
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        //用LinkedList做一个队列：先进先出，后进后出
        LinkedList<String> queue = new LinkedList<>();
        queue.addLast("1号");
        queue.addLast("2号");
        queue.addLast("3号");
        queue.addLast("4号");
        System.out.println(queue);

        //出队
        System.out.println(queue.removeFirst());
        System.out.println(queue);

        //通过LinkedList可以模拟一个栈
        LinkedList<String> stack = new LinkedList<>();
        stack.push("杨幂");
        stack.push("古力娜扎");
        stack.push("asas");
        stack.addFirst("迪丽");
        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack);
    }
}
