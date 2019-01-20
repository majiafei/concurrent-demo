package cn.e3mall.lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ProjectName: house
 * @Package: cn.e3mall.lock
 * @ClassName: LockDemo
 * @Author: majiafei
 * @Description:
 * @Date: 2019/1/19 18:32
 */
public class LockDemo {
//    public synchronized static void get(Thread thread) {
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < 5; i++) {
//            try {
//                Thread.sleep(20);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(thread.getName() + ":正在进行读操作……");
//        }
//        System.out.println(thread.getName() + ":读操作完毕！");
//        System.out.println("花费时间:" + (System.currentTimeMillis() - start));
//    }
//
//    public static void main(String[] args) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                get(Thread.currentThread());
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                get(Thread.currentThread());
//            }
//        }).start();
//    }

    public static void get(Thread thread) {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        lock.readLock().lock();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(thread.getName() + ":正在进行读操作……");
        }
        System.out.println(thread.getName() + ":读操作完毕！");
        System.out.println("end time:" + (System.currentTimeMillis()-start));
        lock.readLock().unlock();
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                get(Thread.currentThread());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                get(Thread.currentThread());
            }
        }).start();
    }

}
