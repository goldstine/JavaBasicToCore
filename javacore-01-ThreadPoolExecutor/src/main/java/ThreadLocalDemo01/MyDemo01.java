package ThreadLocalDemo01;

/**
 * 需求：线程隔离
 *      在多线程并发的场景下，每个线程中的变量都是相互独立的
 *      线程A:      设置（变量1）   获取（变量1）
 *      线程B:       设置（变量2）   获取（变量2）
 *
 *      ThreadLocal:  作为一个泛型类，绑定的所有数据不受类型限制
 *          (1)set()
 *          (2)get()
 *
 *
 */
public class MyDemo01 {

    ThreadLocal<String> t1=new ThreadLocal<>();   //字面意思就是当前线程

    private String content;

    public String getContent() {
        String s = t1.get();//当前线程获取对应的数据
        return s;
    }

    public void setContent(String content) {
//        this.content = content;
        //将变量content绑定到当前线程
        t1.set(content); //当前线程绑定该变量
    }

    public static void main(String[] args) {
        MyDemo01 demo = new MyDemo01();
        for (int i = 0; i < 5; i++) {
            //创建5个线程，每一个线程往对象Demo先存数据，然后再取数据
            new Thread(new Runnable() {
                @Override
                public void run() {
                    demo.setContent(Thread.currentThread().getName()+"的数据");
                    System.out.println("----------------------");
                    System.out.println(Thread.currentThread().getName()+"----->"+demo.getContent());
                }
            },"线程"+i).start();
        }
    }

}
