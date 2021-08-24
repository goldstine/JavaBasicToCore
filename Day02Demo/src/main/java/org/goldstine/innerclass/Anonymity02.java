package org.goldstine.innerclass;

/**
 * 匿名内部类使用形式
 */
public class Anonymity02 {


    public static void main(String[] args) {
        Swim s=new Swim() {
            @Override
            public void swimming() {
                System.out.println("goldstine游泳");
            }
        };
        go(s);

        go(new Swim() {
            @Override
            public void swimming() {
                System.out.println("youyou");
            }
        });
    }

    //提供一个方法让全部角色进入比赛
    public static void go(Swim s){
        System.out.println("开始.....");
        s.swimming();

        System.out.println("结束....");
    }

}



interface Swim{
    void swimming();
}
