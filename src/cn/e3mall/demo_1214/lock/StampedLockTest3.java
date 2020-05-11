package cn.e3mall.demo_1214.lock;

import java.util.concurrent.locks.StampedLock;

/**
 * 乐观读
 * @ClassName: StampedLockTest
 * @Auther: admin
 * @Date: 2020/5/11 13:36
 * @Description:
 */
public class StampedLockTest3 {

    private static int c1 = 1;
    private static int c2 = 1;
    private static final StampedLock STAMPED_LOCK = new StampedLock();

    public static int sum() {
        long stamp = STAMPED_LOCK.tryOptimisticRead();

        int cc1 = c1;
        int cc2 = c2;
        System.out.println("获取的数值为：c1 = " + cc1 + "; c2 = " + cc2);
        try {
            // 休眠3秒，目的为了让其他线程有机会修改c1和c2
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 判断是否存在写操作，true：表示不存在；false：表示存在
        if (!STAMPED_LOCK.validate(stamp)) {
            System.out.println("存在写操作！");

            // 存在写锁，升级为悲观读锁
            stamp = STAMPED_LOCK.readLock();

            try {
                System.out.println("升级到悲观读锁");

                cc1 = c1;
                cc2 = c2;
                System.out.println("升级到悲观读锁后，获取的数值为：c1 = " + cc1 + "; c2 = " + cc2);

            } finally {
                STAMPED_LOCK.unlock(stamp);
            }
        }

        return cc1 + cc2;
    }

    public static void updateNum() {
        long writeLock = STAMPED_LOCK.writeLock();

        try {
            c1 = 2;
            c2 = 2;
        } finally {
            STAMPED_LOCK.unlock(writeLock);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("sum = "+ sum());
        });
        thread.start();
        // 先让thread线程获取到最开始的值
        Thread.sleep(1000);
        updateNum();

        thread.join();
        System.out.println("执行结束");


        /***
         * 获取的数值为：c1 = 1; c2 = 1
         * 存在写操作！
         * 升级到悲观读锁
         * 升级到悲观读锁后，获取的数值为：c1 = 2; c2 = 2
         * sum = 4
         * 执行结束
         */
    }

}
