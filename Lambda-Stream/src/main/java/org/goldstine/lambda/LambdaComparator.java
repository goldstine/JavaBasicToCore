package org.goldstine.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 通过Lambda表达式简化Comparator接口的匿名内部类写法
 *
 */
public class LambdaComparator {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<Student>();
        Student s1 = new Student("李明", 18, '男');
        Student s2 = new Student("liulei", 23, '男');
        Student s3 = new Student("王乐乐", 21, '男');
        Collections.addAll(list,s1,s2,s3);
        //按照年龄进行升序排序
//        Collections.sort(list, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o1.getAge()-o2.getAge();
//            }
//        });

        //简化之后
//        Collections.sort(list,(Student o1, Student o2)-> {
//            return o1.getAge()-o2.getAge();
//        });


        //进一步简化之后
//        Collections.sort(list,( o1,  o2)->
//            o1.getAge()-o2.getAge()
//        );

//        Collections.sort(list,( o1,  o2)-> o1.getAge()-o2.getAge());

        //使用静态方法进行简化
//        Collections.sort(list,( o1,  o2)-> Student.compareMethod( o1, o2));

        //通过方法引用进一步简化
//        Collections.sort(list,Student::compareMethod);
        Collections.sort(list,LambdaComparator::compareMethod);
        System.out.println(list);


    }

    public static int compareMethod(Student o1,Student o2){
        return o1.getAge()- o2.getAge();
    }
}
