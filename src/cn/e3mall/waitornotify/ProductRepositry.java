package cn.e3mall.waitornotify;

import org.omg.CORBA.MARSHAL;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @ProjectName: house
 * @Package: cn.e3mall.waitornotify
 * @ClassName: ProductRepositry
 * @Author: majiafei
 * @Description:
 * @Date: 2019/1/18 19:52
 */
public class ProductRepositry {

    private Vector<Product> products = new Vector<>();
    private static final int MAX_NUM = 10;

    public void produce(){
        synchronized (products){
            if (products.size() == MAX_NUM){ //如果仓库已经满了
                try {
                    products.wait();      //让products等待！！！
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //products.size() < MAX_NUM 如果仓库还没有满
            Product product = new Product("包子", System.currentTimeMillis());
            products.add(product);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+ " 生产了： "+ product+" ,产品仓库当前数量： "+ products.size());
            //通知等待的消费者来消费
            products.notify();
//            products.notifyAll();
        }
    }


    public void consume(){
        synchronized (products){
            if (products.size() == 0){ //产品仓库空了，等待生产者生产
                try {
                    products.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Product product = products.firstElement();
            products.remove(0);
            System.out.println(Thread.currentThread().getName()+ " 消费了： " + product+" ,产品仓库当前数量： "+ products.size());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //通知生产者生产
            products.notify();
//            products.notifyAll();
        }
    }


}
