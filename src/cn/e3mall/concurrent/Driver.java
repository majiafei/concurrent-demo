package cn.e3mall.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @ProjectName: house
 * @Package: cn.e3mall.concurrent
 * @ClassName: Driver
 * @Author: majiafei
 * @Description:
 * @Date: 2019/1/19 11:06
 */
public class Driver implements Runnable{

    private String name;
    private CountDownLatch countDownLatch;
    private CyclicBarrier cyclicBarrier;

    public Driver(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;
    }

    public Driver(String name, CyclicBarrier cyclicBarrier) {
        this.name = name;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println("等待工作人员上车");
        try {
            cyclicBarrier.await();
            System.out.println("司机开始开车");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}
