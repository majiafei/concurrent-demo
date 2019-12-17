package cn.e3mall.demo_1214.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class CyclicBarrierTest {

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new SummaryThred());

    private static CopyOnWriteArrayList writeArrayList = new CopyOnWriteArrayList();

    public static class Sporter implements Runnable {

        private String name;

        public Sporter(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(name + "已经准备好");
            writeArrayList.add(name);
            try {
                cyclicBarrier.await();

                System.out.println(name + "开始跑");

                // 计数器可以重复使用
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    private static class SummaryThred extends Thread {
        @Override
        public void run() {
            System.out.println("汇总线程" + writeArrayList);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i <3; i++) {
            new Thread(new Sporter("运动员" + i)).start();
        }
    }

}
