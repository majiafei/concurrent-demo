package cn.e3mall.demo_1214.communication;

import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;

/**
 * 线程通信
 */
public class ThreadCommunication {

    private LinkedList<Integer> linkedList = new LinkedList<>();

    private int initSize = 10;

    public void add(int i) {
        synchronized (linkedList) {
            while (linkedList.size() == initSize) {
                try {
                    System.out.println("容器已经满了");
                    linkedList.wait();
                } catch (InterruptedException e) {
                    System.out.println("线程被中断");
                }
            }

            linkedList.addLast(i);
            linkedList.notifyAll();
        }
    }

    public void get() {
        synchronized (linkedList) {
            while (linkedList.size() == 0) {
                System.out.println("容器中已经为空，等待放入元素");
                try {
                    linkedList.wait();
                } catch (InterruptedException e) {
                    System.out.println("线程被中断");
                }
            }
            System.out.println("获取到的元素为:" + linkedList.removeFirst());
            linkedList.notifyAll();
        }
    }

    private static class Producer implements Runnable {

        private ThreadCommunication threadCommunication;

        public Producer(ThreadCommunication threadCommunication) {
            this.threadCommunication = threadCommunication;
        }

        @Override
        public void run() {
            for (int i = 0; i < 50; i++) {
                threadCommunication.add(i);
            }
        }
    }

    private static class Consumer implements Runnable {
        private ThreadCommunication threadCommunication;

        public Consumer(ThreadCommunication threadCommunication) {
            this.threadCommunication = threadCommunication;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                this.threadCommunication.get();
            }
        }
    }

    public static void main(String[] args) {
        ThreadCommunication threadCommunication = new ThreadCommunication();
        // 生产者
        Producer producer = new Producer(threadCommunication);
        // 消费者
        Consumer consumer = new Consumer(threadCommunication);

        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);

        t1.start();
        t2.start();
    }

}
