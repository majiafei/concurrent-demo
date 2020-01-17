package cn.e3mall.demo_1214.completeservice;

import java.util.concurrent.*;

/**
 * @ClassName: CompleteServiceTest
 * @Auther: admin
 * @Date: 2020/1/17 09:26
 * @Description:
 */
public class CompleteServiceTest {

    private static final int THREAD_COUNT = Runtime.getRuntime().availableProcessors();

    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(THREAD_COUNT, THREAD_COUNT, 0, TimeUnit.MILLISECONDS,
                                                                                  new LinkedBlockingQueue<>(50000));

    private static LinkedBlockingQueue<Future<Integer>> linkedBlockingQueue = new LinkedBlockingQueue<>(10000);

    private static final  int count = 1000;

    /**
     * 方式二的时间是方式一的10倍
     * @param args
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        method1();
        method2();
        threadPoolExecutor.shutdown();
    }

    private static void method1() throws ExecutionException, InterruptedException {
        for (int i = count; i > 0; i--) {
            linkedBlockingQueue.offer(threadPoolExecutor.submit(new MyCallable(i)));
        }

        long l = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            Future<Integer> take = linkedBlockingQueue.take();
            take.get();
//            System.out.println(take.get());
        }
        System.out.println(System.currentTimeMillis() - l + "毫秒");
    }

    private static void method2() throws InterruptedException, ExecutionException {
        long l = System.currentTimeMillis();
        CompletionService producerCompletionService = new ExecutorCompletionService(threadPoolExecutor);
        for (int i = count; i > 0; i--) {
            producerCompletionService.submit(new MyCallable(i));
        }

        for (int i = count; i > 0; i--) {
            Future take = producerCompletionService.take();
            take.get();
//            System.out.println(take.get());
        }
        System.out.println(System.currentTimeMillis() - l + "毫秒:方式二");
    }

    private static class MyCallable implements Callable<Integer>{

        private int m;

        public MyCallable(int m) {
            this.m = m;
        }

        @Override
        public Integer call() throws Exception {
/*            for (int j = 0; j < m * 1000000000; j++) {

            }*/
            for (int i = 0; i < m * 1000000000; i++) {

            }
            return m;
        }
    }

}
