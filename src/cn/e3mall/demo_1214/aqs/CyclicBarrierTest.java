package cn.e3mall.demo_1214.aqs;

import java.util.Objects;
import java.util.concurrent.*;

/**
 * @ClassName: CyclicBarrier
 * @Auther: admin
 * @Date: 2020/3/3 17:41
 * @Description:
 */
public class CyclicBarrierTest {
    /*    */
    /**
     * 场景:有三个运动员一起比赛，其中一个准备好了，必须等待其他两个运动员准备好，比赛才能开始
     *//*
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 0, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(10));

    public static void main(String[] args) {
        Runner runner = new Runner("小明");
        Runner runner2 = new Runner("大明");
        Runner runner3 = new Runner("小大明");

        threadPoolExecutor.execute(runner);
        threadPoolExecutor.execute(runner2);
        threadPoolExecutor.execute(runner3);
    }

    static class Runner implements Runnable {

        private String name;

        public Runner(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                System.out.println(name + "开始准备");
                Thread.sleep(1000);
                System.out.println(name + "准备好了");

                cyclicBarrier.await();

                System.out.println(name + "开始跑步");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }*/



}
