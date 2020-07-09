package cn.e3mall.demo_1214.communication;

/**
 * @ClassName: WaitNotifyTest
 * @Auther: admin
 * @Date: 2020/3/9 15:30
 * @Description:
 */
public class WaitNotifyTest {
    /**
     * 多线程之间需要等待协调，才能完成某种工作，问怎么设计这种协调方案？
     * 如：子线程循环10次，接着主线程循环100，接着又回到子线程循环10次，接着再回到主线程又循环100，如此循环50次。
     */
    private static Object object = new Object();

    private static final int num = 100;

    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int m = 0; m < num; m++) {
                    synchronized (object) {
                        try {
                            for (int i = 0; i < 100; i++) {
                                System.out.println(Thread.currentThread() + "第" + (m + 1) + "次:" + i);
                            }
                            System.out.println(Thread.currentThread() + "第" + (m + 1) + "次运行完毕");

                            object.notifyAll();
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, "子线程");
        t.start();

        for (int m = 0; m < num; m++) {
            synchronized (object) {
                try {
                    object.wait();

                    for (int i = 0; i < 100; i++) {
                        System.out.println(Thread.currentThread() + "第" + (m + 1) + "次:" + i);
                    }
                    System.out.println(Thread.currentThread() + "第" + (m + 1) + "次运行完毕");

                    object.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
