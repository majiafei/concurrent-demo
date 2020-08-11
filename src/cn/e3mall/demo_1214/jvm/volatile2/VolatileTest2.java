package cn.e3mall.demo_1214.jvm.volatile2;

/**
 * volatile能够保证可见性
 * @author majiafei
 * @date 2020/8/11 19:52
 */
public class VolatileTest2 {

    private static volatile boolean stop = false;

    // 不添加volatile，程序循环永远不会结束
//    private static  boolean stop = false;

    public static void doWork() {
        while (!stop) {

        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
            }
        }).start();

        Thread.sleep(1000);

        stop = true;
    }

}
