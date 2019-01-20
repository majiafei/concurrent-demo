package cn.e3mall.automic;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ProjectName: house
 * @Package: cn.e3mall.automic
 * @ClassName: AtomicDemo
 * @Author: majiafei
 * @Description:
 * @Date: 2019/1/19 11:45
 */
public class AtomicDemo {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    private static int m = 0;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 50; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        atomicInteger.getAndIncrement();
                        m++;
                    }
                }
            });
        }
        executorService.shutdown();
        Thread.sleep(6000);
        System.out.println(atomicInteger.get());
        System.out.println(m);
    }

}
