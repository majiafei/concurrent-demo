package cn.e3mall.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ProjectName: house
 * @Package: cn.e3mall.concurrent
 * @ClassName: CountLatchDown
 * @Author: majiafei
 * @Description:
 * @Date: 2019/1/19 11:02
 */
public class CountLatchDownDemo {

/*    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Worker worker1 = new Worker("张三", countDownLatch);
        Worker worker2 = new Worker("李四", countDownLatch);
        Driver driver = new Driver("王五", countDownLatch);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(worker1);
        executorService.execute(worker2);
        executorService.execute(driver);

        executorService.shutdown();
        System.out.println("hello");

    }*/

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        Runner runner1 = new Runner("张三", cyclicBarrier);
        Runner runner = new Runner("李四", cyclicBarrier);
        Runner runner3 = new Runner("王五", cyclicBarrier);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(runner);
        executorService.execute(runner1);
        executorService.execute(runner3);
        executorService.shutdown();
        Thread.sleep(6000);
        cyclicBarrier.reset();
         executorService = Executors.newCachedThreadPool();
        Runner runner4 = new Runner("四号选手",cyclicBarrier);
        Runner runner5 = new Runner("五号选手", cyclicBarrier);
        Runner runner6 = new Runner("六号选手", cyclicBarrier);
        executorService.execute(runner4);
        executorService.execute(runner5);
        executorService.execute(runner6);
    }


}
