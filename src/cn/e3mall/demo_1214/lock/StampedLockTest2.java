package cn.e3mall.demo_1214.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.locks.StampedLock;
import java.util.logging.Logger;

/**
 * 验证悲观读和写锁是互斥的
 * @ClassName: StampedLockTest
 * @Auther: admin
 * @Date: 2020/5/11 13:36
 * @Description:
 */
public class StampedLockTest2 {

    // 充当缓存的角色
    private static final Map<String, String> MAP_CACHE = new HashMap<>();
    // 充当数据库的角色
    private static final Map<String, String> DB_MAP = new HashMap<>();

    private static final StampedLock STAMPED_LOCK = new StampedLock();

    private static final Logger LOGGER = Logger.getLogger(StampedLockTest2.class.getName());

    static {
        DB_MAP.put("zhangsan","你好，我是张三");
        DB_MAP.put("lisi","你好，我是李四");
    }

    // 悲观读
    public static String getInfo(String name) throws InterruptedException {
        // 获取悲观读
        long stamp = STAMPED_LOCK.readLock();

        LOGGER.info(Thread.currentThread().getName() + "获取到了悲观读锁");

        if ("zhangsan".equals(name)) {
            LOGGER.info(Thread.currentThread().getName() + "开始休眠");
            // 张三的线程先休眠3秒，看是否李四的线程是否能够获取到写锁
            Thread.sleep(3000);
            LOGGER.info(Thread.currentThread().getName() + "休眠结束");
        }

        try {
            String info  = MAP_CACHE.get(name);
            if (Objects.nonNull(info)) {
                LOGGER.info(Thread.currentThread().getName() + "在缓存中获取了数据：" + info);
                return info;
            }
        } finally {
            // 释放悲观读锁
            STAMPED_LOCK.unlock(stamp);
            LOGGER.info(Thread.currentThread().getName() + "释放了悲观读锁");
        }

        // 获取写锁
        stamp = STAMPED_LOCK.writeLock();
        LOGGER.info(Thread.currentThread().getName() + "获取到了写锁");
        try {
            String info = MAP_CACHE.get(name);
            if (Objects.nonNull(info)) {
                LOGGER.info(Thread.currentThread().getName() + "获取到了写锁，再次确认在缓存中获取到了数据：" + info);
                return info;
            }

            String infoFromDb = DB_MAP.get(name);
            MAP_CACHE.put(name, infoFromDb);
            LOGGER.info(Thread.currentThread().getName() + "缓存没有数据，从数据库中获取了数据：" + infoFromDb);

            return infoFromDb;
        } finally {
            // 释放写锁
            STAMPED_LOCK.unlock(stamp);
            LOGGER.info(Thread.currentThread().getName() + "释放了写锁 ");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread zhangsan = new Thread(() -> {
            try {
                getInfo("zhangsan");
            } catch (InterruptedException e) {
                e.printStackTrace();
                LOGGER.info(Thread.currentThread().getName() + "获取数据失败");
            }
        }, "zhangsan 线程：");

        Thread lisi = new Thread(() -> {
            try {
                getInfo("lisi");
            } catch (InterruptedException e) {
                e.printStackTrace();
                LOGGER.info(Thread.currentThread().getName() + "获取数据失败");
            }
        }, "lisi线程：");

        zhangsan.start();
        lisi.start();


        zhangsan.join();
        lisi.join();

        /**
         * zhangsan线程休眠结束，lisi线程才获取到写锁，由此可知，写锁和悲观读锁是互斥的。
         */

        /**
         * 五月 11, 2020 2:49:25 下午 cn.e3mall.demo_1214.lock.StampedLockTest2 getInfo
         * 信息: zhangsan 线程：获取到了悲观读锁
         * 五月 11, 2020 2:49:25 下午 cn.e3mall.demo_1214.lock.StampedLockTest2 getInfo
         * 信息: lisi线程：获取到了悲观读锁
         * 五月 11, 2020 2:49:25 下午 cn.e3mall.demo_1214.lock.StampedLockTest2 getInfo
         * 信息: zhangsan 线程：开始休眠
         * 五月 11, 2020 2:49:25 下午 cn.e3mall.demo_1214.lock.StampedLockTest2 getInfo
         * 信息: lisi线程：释放了悲观读锁
         * 五月 11, 2020 2:49:28 下午 cn.e3mall.demo_1214.lock.StampedLockTest2 getInfo
         * 信息: zhangsan 线程：休眠结束
         * 五月 11, 2020 2:49:28 下午 cn.e3mall.demo_1214.lock.StampedLockTest2 getInfo
         * 信息: zhangsan 线程：释放了悲观读锁
         * 五月 11, 2020 2:49:28 下午 cn.e3mall.demo_1214.lock.StampedLockTest2 getInfo
         * 信息: lisi线程：获取到了写锁
         * 五月 11, 2020 2:49:28 下午 cn.e3mall.demo_1214.lock.StampedLockTest2 getInfo
         * 信息: lisi线程：缓存没有数据，从数据库中获取了数据：你好，我是李四
         * 五月 11, 2020 2:49:28 下午 cn.e3mall.demo_1214.lock.StampedLockTest2 getInfo
         * 信息: lisi线程：释放了写锁
         * 五月 11, 2020 2:49:28 下午 cn.e3mall.demo_1214.lock.StampedLockTest2 getInfo
         * 信息: zhangsan 线程：获取到了写锁
         * 五月 11, 2020 2:49:28 下午 cn.e3mall.demo_1214.lock.StampedLockTest2 getInfo
         * 信息: zhangsan 线程：缓存没有数据，从数据库中获取了数据：你好，我是张三
         * 五月 11, 2020 2:49:28 下午 cn.e3mall.demo_1214.lock.StampedLockTest2 getInfo
         * 信息: zhangsan 线程：释放了写锁
         */
    }

}
