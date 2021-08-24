package org.goldstine.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 保障原子性的第二种方式：通过原子类
 *      java从jdk1.5开始提供了java.util.concurrent.atomic（简称Atomic包），
 *      这个包中的原子类提供了一种用法简单，性能搞笑，线程安全地更新一个变量的方式
 *
 *      AtomicInteger原子型Integer，可以实现原子更新操作
 *      public AtomicInteger();初始化一个默认值为0的原子型Integer
 *      public AtomicInteger(int initialValue):初始化一个指定值的原子型Integer
 *
 *      int get();   获取值
 *      int getAndIncrement();以原子方式将当前值加1，注意：这里返回的是自增前的值
 *      int incrementAndGet();以原子方式将当前值加1，注意：这里返回的是自增后的值
 *      int addAndGet(int data) ;以原子方式将输入的数值与实例中的值
 *      int getAndSet(int value):以原子方式设置为newValue的值，并返回旧值
 *
 *      使用原子类保证原子操作
 *
 *      加锁保证原子操作的方式性能较差，但是为什么通过原子类的方式性能较好呢？
 *      原子类CAS机制实现线程安全
 *
 *
 *       CAS:乐观锁    synchronized：悲观锁
 *       CAS和synchronized都可以保证多线程环境下共享数据的安全性，区别：
 *          synchronized是从悲观的角度出发：
 *              总是假设最坏的情况，每次去拿数据的时候都认为别人会修改，所以每次在哪数据的时候都会上锁，这样别人想拿这个数据
 *              就会阻塞直到他拿到锁
 *              【共享资源每次只给一个线程使用，其它线程阻塞，用完后再把资源转让给其他线程，因此synchroninzed称为悲观锁】
 *              jdk中的ReetrantLock也是一种悲观锁，性能较差
 *              CAS是从乐观的角度出发：
 *              总是假设最好的情况，每次去拿数据的时候都认为别人不会修改，所以不会上所，但在更新世会判断一下在此期间别人有没有更新这个数据
 *
 *         原子包性能更好原因：
 *              底层基于CAS乐观锁机制，每次修改数据不回家所，等到修改的时候判断有没有别人修改
 *
 *              一般CAS+volatile修饰共享变量可以减少冲突，能够得到最新的值进行修改
 *              所以性能会更好
 *
 *
 */
public class VolatileAtomicDemo02 {
    public static void main(String[] args) {
        //创建线程任务对象
        Runnable target = new MyRunnable01();
        for (int i = 0; i < 100; i++) {
            new Thread(target).start();
        }

    }
}

//创建一个线程任务类
class MyRunnable01 implements Runnable{

    //通过原子类实现原子操作
    private AtomicInteger at=new AtomicInteger(0);

    private /*volatile*/ int count;//volatile并不能保证原子性
    @Override
    public void run() {
//        synchronized ("liulei") {//加锁之后可以保证可见性，所以不需要再加volatile
            for (int i = 1; i <= 100; i++) {
                count++;
//                System.out.println("count ========>>>" + count);
                //通过原子类进行自增1
                System.out.println("count=========>>>"+at.incrementAndGet());
            }
//        }
    }
}
