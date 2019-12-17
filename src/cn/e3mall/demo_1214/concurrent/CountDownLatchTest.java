package cn.e3mall.demo_1214.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class CountDownLatchTest {


    private static CountDownLatch countDownLatch = new CountDownLatch(2);

    private static class Worker implements Runnable {

        private String name;

        public Worker(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(name +"已经完成了工作");
            countDownLatch.countDown();
        }
    }

    private static class Boss implements Runnable {

        private String name;

        public Boss(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                countDownLatch.await();
                System.out.println(name + "开始检查工作");
            } catch (InterruptedException e) {
                System.out.println("老板被中断");
            }
        }
    }

    public static void main(String[] args) {
        Worker worker = new Worker("张三");
        Worker worker2 = new Worker("李四");
        Boss boss = new Boss("王五");

        Thread t1 = new Thread(worker);
        Thread t2 = new Thread(worker2);
        Thread t3 = new Thread(boss);

        t1.start();
        t2.start();
        t3.start();


    }

}
