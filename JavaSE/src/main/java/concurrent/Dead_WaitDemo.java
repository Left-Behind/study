package main.java.concurrent;

/**
 * @author ：Azhu
 * @date ：Created in 2019/9/20 11:09
 * @description：wait方法的使用
 */
public class Dead_WaitDemo {
    //资源 1
    private static Object resource1 = new Object();
    //资源 2
    private static Object resource2 = new Object();
    public static void main(String[] args) {
        Thread thread1=new Thread(() -> {
            //对resource1加锁
            synchronized (resource1) {
                System.out.println(Thread.currentThread() + "get resource1");
                try {
                    //线程睡眠1s保证两个线程同时进入run方法
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource2");
               // resource1.notify();
                synchronized (resource2) {
                    System.out.println(Thread.currentThread() + "get resource2");
                }
            }
        }, "线程 1");

        Thread thread2=new Thread(() -> {
            //对resource2加锁
            synchronized (resource2) {
                System.out.println(Thread.currentThread() + "get resource2");
                try {
                    //线程睡眠1s保证两个线程同时进入run方法
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource1");
                try {
                    resource2.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resource1) {
                    System.out.println(Thread.currentThread() + "get resource1");
                }
            }
        }, "线程 2");
        thread1.start();
        thread2.start();

    }
}
