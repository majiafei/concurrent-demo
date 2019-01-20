package cn.e3mall.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ProjectName: house
 * @Package: cn.e3mall.thread
 * @ClassName: ThreadDemo
 * @Author: majiafei
 * @Description:
 * @Date: 2019/1/18 15:55
 */
public class ThreadDemo<K,V> {

    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();
    private final Map<K, V> map;

    public ThreadDemo(Map<K, V> map) {
        this.map = map;
    }

    /*************   这是用lock()方法写的   ********************/
//    public V put(K key, V value){
//        writeLock.lock();
//        try {
//            return map.put(key, value);
//        }finally {
//            writeLock.unlock();
//        }
//    }
//    public V get(K key){
//        readLock.lock();
//        try {
//            return map.get(key);
//        }finally {
//            readLock.unlock();
//        }
//    }

    /*************   这是用tryLock()方法写的   ********************/
    public V put(K key, V value) {
        while (true) {
            if (writeLock.tryLock()) {
                try {
                    System.out.println("put " + key + " = " + value);
                    return map.put(key, value);
                } finally {
                    writeLock.unlock();
                }
            }
        }
    }

    public V get(K key) {
        while (true) {
            if (readLock.tryLock()) {
                try {
                    V v = map.get(key);
                    System.out.println("get " + key + " = " + v);
                    return v;
                } finally {
                    readLock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final ThreadDemo<String, Integer> rw = new ThreadDemo<>(new HashMap<>());
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            exec.execute(new TestRunnable(rw));
        }
        exec.shutdown();
    }

    static class TestRunnable implements Runnable {
        private final ThreadDemo<String, Integer> rw;
        private final String KEY = "x";

        TestRunnable(ThreadDemo<String, Integer> rw) {
            this.rw = rw;
        }

        @Override
        public void run() {
            Random random = new Random();
            int r = random.nextInt(100);
            //生成随机数，小于30的写入缓存，大于等于30则读取数字
            if (r < 30) {
                rw.put(KEY, r);
            } else {
                rw.get(KEY);
            }
        }


    }
}
