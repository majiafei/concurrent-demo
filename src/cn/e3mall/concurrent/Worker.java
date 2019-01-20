package cn.e3mall.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @ProjectName: house
 * @Package: cn.e3mall.concurrent
 * @ClassName: Worker
 * @Author: majiafei
 * @Description:
 * @Date: 2019/1/19 11:04
 */
public class Worker implements Runnable{

    private String name;

    private CountDownLatch countDownLatch;

    public Worker(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println(name + "已经准备好");
        countDownLatch.countDown();
    }

}
