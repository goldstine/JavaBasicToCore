package org.goldstine.atomic;

/**
 * 原子性
 *volatile只能保证线程之间变量的可见性，但是不能保证变量操作的原子性
 *
 *
 *
 */
public class VolatileAtomicDemo01 {
    public static void main(String[] args) {
        //创建线程任务对象
        Runnable target = new MyRunnable();
        for (int i = 0; i < 100; i++) {
            new Thread(target).start();
        }

    }
}

//创建一个线程任务类
class MyRunnable implements Runnable{

    private /*volatile*/ int count;//volatile并不能保证原子性
    @Override
    public void run() {
        synchronized ("liulei") {//加锁之后可以保证可见性，所以不需要再加volatile
            for (int i = 1; i <= 100; i++) {
                count++;
                System.out.println("count ========>>>" + count);

            }
        }
    }
}