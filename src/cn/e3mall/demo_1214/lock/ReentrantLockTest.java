package cn.e3mall.demo_1214.lock;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author majiafei
 * @date 2020/8/13 20:04
 */
public class ReentrantLockTest {

    private static final ReentrantLock reentrantLock = new ReentrantLock(true);

    private static final ReadWriteLock READ_WRITE_LOCK = new ReentrantReadWriteLock();


    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(100);
        arrayBlockingQueue.add("xxx");
        arrayBlockingQueue.offer("xxx");
        arrayBlockingQueue.peek();
        arrayBlockingQueue.poll();

        // 会阻塞
        arrayBlockingQueue.put("xxx");
        // 会阻塞
        arrayBlockingQueue.take();
    }

}
