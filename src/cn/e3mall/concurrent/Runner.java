package cn.e3mall.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @ProjectName: house
 * @Package: cn.e3mall.concurrent
 * @ClassName: Runner
 * @Author: majiafei
 * @Description:
 * @Date: 2019/1/19 11:23
 */
public class Runner implements Runnable {

    private String name;
    private CyclicBarrier cyclicBarrier;

    public Runner(String name, CyclicBarrier cyclicBarrier) {
        this.name = name;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println(name + "准备好了");
        try {
            cyclicBarrier.await();
            System.out.println(name + "开始起跑");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
