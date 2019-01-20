package cn.e3mall.blockqueue;


//import cn.e3mall.waitornotify.ProductRepositry;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ProjectName: house
 * @Package: cn.e3mall.blockqueue
 * @ClassName: Master
 * @Author: majiafei
 * @Description:
 * @Date: 2019/1/20 10:46
 */
public class Master {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ProductRep productRep = new ProductRep();

        // 生产者
        for (int i = 0; i < 1; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        productRep.addProduct(j);
                    }
                }
            });
        }
        // 消费者
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                for (int j =0; j < 10; j++){
                    productRep.consumeProduct();
                }
            }
        });
        executorService.shutdown();
    }

}
