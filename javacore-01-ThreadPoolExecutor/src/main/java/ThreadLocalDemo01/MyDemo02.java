package ThreadLocalDemo01;

/**
 * 将ThreadLocal与synchornized进行比较
 * synchronized：多线程之间访问资源的同步
 * ThreadLocal:多线程中让每个线程之间的数据相互隔离
 *
 * 虽然ThreadLocal和Synchronized都能解决并发访问的问题，但是使用ThreadLocal更为合适，因为这样可以使程序拥有更高的并发性
 */

public class MyDemo02 {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static void main(String[] args) {
        MyDemo01 demo = new MyDemo01();
        for (int i = 0; i < 5; i++) {
            //创建5个线程，每一个线程往对象Demo先存数据，然后再取数据
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (MyDemo02.class) {
                        demo.setContent(Thread.currentThread().getName() + "的数据");
                        System.out.println("----------------------");
                        System.out.println(Thread.currentThread().getName() + "----->" + demo.getContent());
                    }
                }
            },"线程"+i).start();
        }
    }

}
