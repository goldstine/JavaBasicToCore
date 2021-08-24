package org.goldstine.SetDemo03;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * TreeSet集合
 * TreeSet集合：不重复，无索引，按照大小默认升序排序
 * TreeSet集合称为排序不重复集合，可以对元素进行默认的升序排序
 *【LinkedHashSet是有序不重复   TreeSet是排序不重复】
 *
 * TreeSet集合子排序的方式：
 * （1）有值特性的元素可以直接升序排序（浮点型，整型）
 * （2）字符串类型的元素会按照首字符的编号排序
 * （3）对于自定义的引用数据类型，TreeSet默认无法排序，执行的时候直接报错，因为不知道排序规则
 * 自定义引用数据类型的排序实现：
 *      对于自定义的引用数据类型，TreeSet默认无法排序
 *      所以我们需要定制排序的大小规则，定义大小规则的方式有两种：
 *      —（1）直接为对象的类实现比较规则Comparable接口，实现对应的比较方法
 *          【比较规则】
 *      （2）直接为集合设置比较器Comparator对象
 *          【比较器】
 *
 *          如果类和集合都存在比较规则，默认使用集合自带的规则进行大小排序
 */
public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Double> integers = new TreeSet<>();
        integers.add(100.0);
        integers.add(99.9);
        integers.add(0.1);
        integers.add(89.3);
        System.out.println(integers);


        //字符串按照字典序进行排序
        TreeSet<String> names = new TreeSet<>();
        names.add("Jack");
        names.add("rose");
        names.add("Dlei");
        names.add("about");
        names.add("曹雪芹");//中文的ascii比较大
        names.add("bozai");
        names.add("caocao");
        names.add("Angle");

        System.out.println(names);

        //引用数据类型进行排序TreeSet
        TreeSet<Employee> employees = new TreeSet<>();
        employees.add(new Employee("goldstine",6500.0,21));
        employees.add(new Employee("liulei",7500.0,20));
        employees.add(new Employee("sun",4500.0,23));
        System.out.println(employees);

        System.out.println("=======第二种排序方式=======");
        TreeSet<Employee> emp = new TreeSet<>(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                //o1是比较者，o2是被比较者
                /*
                 * java规则：
                 * 如果认为比较这this大于被比较者，返回正数
                 * 如果认为比较者this小于被比较者，返回负数
                 * 如果认为比较者this等于被比较者，返回0
                 */
                return o2.getAge()-o1.getAge();//优先使用集合自带的比较器，然后使用类的比较规则，
                // 这样更适合比较规则的定制化
            }
        });
        emp.add(new Employee("goldstine",6500.0,21));
        emp.add(new Employee("liulei",7500.0,20));
        emp.add(new Employee("sun",4500.0,23));
        System.out.println(emp);
    }
}
