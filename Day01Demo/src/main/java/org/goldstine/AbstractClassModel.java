package org.goldstine;

/**
 * 抽象类的模板设计模式
 *
 * 设计模式：
 *      设计模式是前人或者技术大牛或者软件行业在生产实战中发现的优秀软件设计架构思想
 *      后来者可以直接使用这些架构或者思想就可以设计出优秀，提高效率，提高软件可扩展性和可维护性的软件
 *
 */
public class AbstractClassModel {

    public static void main(String[] args) {
        Student student = new Student();
        student.write();

    }

}

//子类继承抽象类
class Student extends Template{

    @Override
    public String writeMain() {
        return "Goldstine";
    }
}

//设计一个模板类
abstract class Template{
    private String title="asasas";
    private String begin="\t\t12222222222222";
    private String last="\t\tjljlalskalskal";

    public void write(){
        System.out.println(title);
        System.out.println(begin);
        System.out.println(writeMain());
        System.out.println(last);
    }

    public abstract String writeMain();

}

