package cn.e3mall.demo_1214.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: CountDownLaunchTest
 * @Auther: admin
 * @Date: 2020/3/3 12:38
 * @Description:
 */
public class CountDownLaunchTest {

    private static CountDownLatch countDownLatch = new CountDownLatch(2);

    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10,
            0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(100));

    public static void main(String[] args) {
        Worker worker1 = new Worker("张三");
        Worker worker2 = new Worker("李斯");

        Boss boss = new Boss("王五");

        threadPoolExecutor.execute(worker1);
        threadPoolExecutor.execute(worker2);
        threadPoolExecutor.execute(boss);

        threadPoolExecutor.shutdown();
    }


    static class Worker implements Runnable {

        private String name;

        public Worker(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(name + "已经做完了工作");
            countDownLatch.countDown();
        }
    }

    static class Boss implements Runnable {

        private String name;

        public Boss(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("等待员工完成工作");
            try {
                countDownLatch.await();
                System.out.println(name + "开始检查工作=======================");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
