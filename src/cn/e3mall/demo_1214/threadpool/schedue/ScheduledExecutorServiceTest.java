package cn.e3mall.demo_1214.threadpool.schedue;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: ScheduledExecutorServiceTest
 * @Auther: admin
 * @Date: 2020/5/22 16:00
 * @Description:
 */
public class ScheduledExecutorServiceTest {
    private static final ScheduledThreadPoolExecutor SCHEDULED_THREAD_POOL_EXECUTOR = new ScheduledThreadPoolExecutor(10);

    public static void main(String[] args) {
        // 只执行一次
        SCHEDULED_THREAD_POOL_EXECUTOR.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("xxxxxxxxxxxxx");
                SCHEDULED_THREAD_POOL_EXECUTOR.schedule(this, 10, TimeUnit.MILLISECONDS);
            }
        }, 10, TimeUnit.MILLISECONDS);
    }
}
