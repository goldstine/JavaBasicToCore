package demo05;

//模拟取款的任务
public class MyTask implements Runnable{

    //卡中的余额
    private static double total=1000;

    //每一个人的取款金额
    private double money;

    //记录取钱的姓名
    private String username;

    public MyTask(String username,double money) {
        this.username = username;
        this.money=money;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(username+"正在使用"+name+"取钱"+money+"。。。。");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (MyTask.class) {
            if (total-money >= 0) {
                total -= money;
                System.out.println(username+"使用"+name+"取钱成功"+money+"元....,余额为："+total);
            } else {
                System.out.println(username+"使用"+name+"取钱失败....");
            }
        }
    }
}
