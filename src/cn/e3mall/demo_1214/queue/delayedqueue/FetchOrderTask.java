package cn.e3mall.demo_1214.queue.delayedqueue;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.concurrent.DelayQueue;

public class FetchOrderTask implements Runnable{

    private DelayQueue<ItemVo<Order>> delayQueue;

    public FetchOrderTask(DelayQueue<ItemVo<Order>> delayQueue) {
        this.delayQueue = delayQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                ItemVo<Order> take = delayQueue.take();
                Order data = take.getData();
                System.out.println("取出" + data.getOrderId() + ":" + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
