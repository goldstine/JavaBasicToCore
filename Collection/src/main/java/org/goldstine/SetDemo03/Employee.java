package org.goldstine.SetDemo03;

public class Employee implements Comparable<Employee>{
    private String name;
    private double salary;
    private int age;

    public Employee() {
    }

    public Employee(String name, double salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    //实现比较方法，方便TreeSet进行排序，集合会自动调用e1.compareTo(o)进行大小比较
    //比较这this,调用者
    @Override
    public int compareTo(Employee o) {
        /**
         * java规则：
         * 如果认为比较这this大于被比较者，返回正数
         * 如果认为比较者this小于被比较者，返回负数
         * 如果认为比较者this等于被比较者，返回0
         */

        //加入当前需求按照年龄进行比较
//        if(this.age>o.age){
//            return this.age-o.age;
//        }else if(this.age<o.age){
//            return this.age-o.age;
//        }else{
//            return 0;
//        }
        return this.age-o.age;

        //需求：
    }

}
