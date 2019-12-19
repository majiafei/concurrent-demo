package cn.e3mall.demo_1214.container;

import java.util.concurrent.*;

/**
 * @ClassName: LinkedBlockingQueueTest
 * @Auther: admin
 * @Date: 2019/12/19 17:27
 * @Description:
 */
public class LinkedBlockingQueueTest {

    public static void main(String[] args) {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(10);
        try {
            linkedBlockingQueue.put("============");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ExecutorService executorService = new ThreadPoolExecutor(1, 1, 0,
                TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(1));
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("================");
            }
        });
    }

}
