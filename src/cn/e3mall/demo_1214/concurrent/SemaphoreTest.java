package cn.e3mall.demo_1214.concurrent;

import cn.e3mall.demo_1214.communication.ThreadCommunication;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    private LinkedList<Integer> linkedList = new LinkedList<>();

    private int initSize = 10;

    private Semaphore useful = new Semaphore(10);
    private Semaphore useless = new Semaphore(0);

    public void add(int i) {
        try {
            useful.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        linkedList.addLast(i);
        System.out.println("放入元素" + i);
        useless.release();
    }

    public void get() {
        try {
            useless.acquire();
            System.out.println("获取到的元素为:" + linkedList.removeFirst());
            useful.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class Producer implements Runnable {

        private SemaphoreTest semaphoreTest;

        public Producer(SemaphoreTest semaphoreTest) {
            this.semaphoreTest = semaphoreTest;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                semaphoreTest.add(i);
            }
        }
    }

    private static class Consumer implements Runnable {
        private SemaphoreTest semaphoreTest;

        public Consumer(SemaphoreTest semaphoreTest) {
            this.semaphoreTest = semaphoreTest;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                this.semaphoreTest.get();
            }
        }
    }

    public static void main(String[] args) {
        SemaphoreTest semaphoreTest = new SemaphoreTest();
        // 生产者
        Producer producer = new Producer(semaphoreTest);
        // 消费者
        Consumer consumer = new Consumer(semaphoreTest);

        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);

        t1.start();
        t2.start();
    }
}
