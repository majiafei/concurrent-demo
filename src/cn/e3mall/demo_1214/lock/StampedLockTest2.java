package cn.e3mall.demo_1214.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.locks.StampedLock;
import java.util.logging.Logger;

/**
 * 参照：https://mp.weixin.qq.com/s?__biz=MzIwNjg4MzY4NA==&mid=2247484716&idx=1&sn=ec462e9a5acf82d6ef1fb5859805e58f&chksm=971b9b27a06c1231fc0baf878746f5379047136eec7cb530d3322aee5df5eeaf93c2a131643e&mpshare=1&scene=1&srcid=&sharer_sharetime=1589035388085&sharer_shareid=bb790988e02526a465a6d259669b91ee&key=14ed3836f8067fda8601cf3b5299aeaf65b8f9963115cc2d48f0c3ac92f9383a599f9ca6b3ce98a2f217ed0a2800014fac4e5fb7ddd8e76e76a6f0c84e5e5489a483cc33868736608c2c170b842f79a0&ascene=1&uin=MjQ3MTIzMDUzMA%3D%3D&devicetype=Windows+10&version=62060739&lang=zh_CN&exportkey=Aw74yIQFfTfchYGupcWHq1s%3D&pass_ticket=iG4hkKIdR2ie5D9vl2%2BTGBVga5NPBsrbX0R83HJGWMHtDj3DgAbgSF5M27fdr3Yn
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
