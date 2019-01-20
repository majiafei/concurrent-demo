package cn.e3mall.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @ProjectName: house
 * @Package: cn.e3mall.blockqueue
 * @Author: majiafei
 * @Description:
 * @Date: 2019/1/20 10:41
 */
public class ProductRep {

//    private BlockingQueue<Product> blockingQueue = new LinkedBlockingDeque(10);
    private BlockingQueue<Product> blockingQueue = new ArrayBlockingQueue(10);

    public void addProduct(int i) {
        Product product = new Product("馒头", Long.valueOf(i));
        try {
            blockingQueue.put(product);
            System.out.println(Thread.currentThread().getName() + "放入产品" + product + "：产品的数量为" + blockingQueue.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void consumeProduct() {
        try {
            Product pro = blockingQueue.take();
            System.out.println(Thread.currentThread().getName() + "消费产品为" + pro + ";剩余产品的数量为" + blockingQueue.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
