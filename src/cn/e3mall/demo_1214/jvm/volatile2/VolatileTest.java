package cn.e3mall.demo_1214.jvm.volatile2;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * volatile 不能保证原子性
 * @author majiafei
 * @date 2020/8/11 19:43
 */
public class VolatileTest {
    private static volatile int p = 0;

    private static final ThreadPoolExecutor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(20, 20,
            10, TimeUnit.MICROSECONDS, new LinkedBlockingQueue<>(1000));

    public static void incr() {
        p++;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            THREAD_POOL_EXECUTOR.execute(new Runnable() {
                @Override
                public void run() {
                    incr();
                }
            });
        }

        Thread.sleep(2000);

        // 输出的结果不确定
        System.out.println(p);

        THREAD_POOL_EXECUTOR.shutdown();
    }
}
