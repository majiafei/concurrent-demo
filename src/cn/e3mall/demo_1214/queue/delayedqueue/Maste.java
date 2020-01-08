package cn.e3mall.demo_1214.queue.delayedqueue;

import java.util.concurrent.DelayQueue;

public class Maste {

    public static void main(String[] args) throws InterruptedException {
        DelayQueue<ItemVo<Order>> delayQueue = new DelayQueue<>();
        FetchOrderTask fetchOrderTask = new FetchOrderTask(delayQueue);
        PutOrderTask putOrderTask = new PutOrderTask(delayQueue);

        new Thread(fetchOrderTask).start();
        new Thread(putOrderTask).start();


        System.out.println(1578402139495L - 1578402134495L);
        for (int i = 0; i < 15; i++) {
            Thread.sleep(500);
            System.out.println(i * 500);
        }

    }

}
