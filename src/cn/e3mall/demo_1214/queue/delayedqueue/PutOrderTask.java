package cn.e3mall.demo_1214.queue.delayedqueue;

import java.util.concurrent.DelayQueue;

public class PutOrderTask implements Runnable {

    private DelayQueue<ItemVo<Order>> delayQueue;

    public PutOrderTask(DelayQueue<ItemVo<Order>> delayQueue) {
        this.delayQueue = delayQueue;
    }

    @Override
    public void run() {
        Order order = new Order("majiafeifjdsijf");
        ItemVo<Order> itemVo = new ItemVo<>(5, order);
        delayQueue.offer(itemVo);
        System.out.println(order.getOrderId() + ":" + System.currentTimeMillis());

        Order order2 = new Order("xiaoming");
        ItemVo<Order> itemVo2 = new ItemVo<>(8, order2);
        delayQueue.offer(itemVo2);
        System.out.println(order2.getOrderId() + ":" + System.currentTimeMillis());
    }
}
