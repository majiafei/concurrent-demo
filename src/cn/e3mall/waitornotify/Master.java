package cn.e3mall.waitornotify;

/**
 * @ProjectName: house
 * @Package: cn.e3mall.waitornotify
 * @ClassName: Master
 * @Author: majiafei
 * @Description:
 * @Date: 2019/1/18 20:07
 */
public class Master {

    public static void main(String[] args) throws InterruptedException {
        ProductRepositry productRepositry = new ProductRepositry();
        Producer producer = new Producer(productRepositry);
        Consumer consumer = new Consumer(productRepositry);

        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);
        Thread t3 = new Thread(consumer);
        t1.start();
        t2.start();
        t3.start();
    }

}
