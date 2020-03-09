package cn.e3mall.demo_1214.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ClassName: ReadWriteLockTest
 * @Auther: admin
 * @Date: 2020/3/9 15:38
 * @Description:
 */
public class ReadWriteLockTest {

    // 写写互斥；写读互斥；读读共享
    private static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();

    public static void read() {
        readLock.lock();

        try {
            System.out.println(Thread.currentThread() + " read start");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread() + " read end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }

    public static void write() {
        writeLock.lock();

        try {
            System.out.println(Thread.currentThread() + " write start");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread() + " write end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
/*        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                read();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                read();
            }
        });

        t1.start();
        t2.start();*/


        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                write();
            }
        });
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                read();
            }
        });

        t3.start();
        t4.start();

//        System.out.println((1 << 16) - 1);

        //  00000000000000001
        //  01111111111111111 65535 底16位  写锁的状态
        // 10000000000000000 65536  高16位   读锁的状态
        System.out.println(65536 >>> 16); // 1

    }

}
