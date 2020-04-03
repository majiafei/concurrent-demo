package cn.e3mall.demo_1214.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(4);

        arrayBlockingQueue.put(5);
        arrayBlockingQueue.take();

        arrayBlockingQueue.offer(4);
        arrayBlockingQueue.poll();


        LinkedBlockingQueue blockingQueue = new LinkedBlockingQueue();
        blockingQueue.put(4);
        blockingQueue.take();

        ConcurrentLinkedQueue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue<String>();
        concurrentLinkedQueue.add("xxxxx");

    }

}
