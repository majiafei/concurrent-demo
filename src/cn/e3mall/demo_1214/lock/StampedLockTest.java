package cn.e3mall.demo_1214.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.locks.StampedLock;

/**
 * @ClassName: StampedLockTest
 * @Auther: admin
 * @Date: 2020/5/11 13:36
 * @Description:
 */
public class StampedLockTest {

    // 充当缓存的角色
    private static final Map<String, String> MAP_CACHE = new HashMap<>();
    // 充当数据库的角色
    private static final Map<String, String> DB_MAP = new HashMap<>();

    private static final StampedLock STAMPED_LOCK = new StampedLock();

    static {
        DB_MAP.put("zhangsan","你好，我是张三");
        DB_MAP.put("sili","你好，我是李四");
    }

    // 悲观读
    public static String getInfo(String name) {
        // 获取悲观读
        long stamp = STAMPED_LOCK.readLock();

        try {
            String info  = MAP_CACHE.get(name);
            if (Objects.nonNull(info)) {
                System.out.println("在缓存中获取到了数据: " + info);
                return info;
            }
        } finally {
            // 释放悲观读锁
            STAMPED_LOCK.unlock(stamp);
        }

        // 获取写锁
        stamp = STAMPED_LOCK.writeLock();
        try {
            String info = MAP_CACHE.get(name);
            if (Objects.nonNull(info)) {
                System.out.println("获取到了写锁，再次确认从缓存中获取了数据：" + info);
                return info;
            }

            String infoFromDb = DB_MAP.get(name);
            MAP_CACHE.put(name, infoFromDb);
            System.out.println("缓存没有数据，从数据库中获取了数据：" + infoFromDb);

            return infoFromDb;
        } finally {
            // 释放写锁
            STAMPED_LOCK.unlock(stamp);
        }
    }

    public static void main(String[] args) {
        //线程1
        Thread t1 = new Thread(() ->{
            getInfo("zhangsan");
        });
//线程2
        Thread t2 = new Thread(() ->{
            getInfo("zhangsan");
        });
//线程启动
        t1.start();
        t2.start();

        /**
         * 结果1：
         * 缓存没有数据，从数据库中获取了数据：你好，我是张三
         * 获取到了写锁，再次确认从缓存中获取了数据：你好，我是张三
         */

        /**
         * 结果2：
         *缓存没有数据，从数据库中获取了数据：你好，我是张三
         *在缓存中获取到了数据: 你好，我是张三
         */

        // 综上：一定有一个线程是从缓存中获取的。
    }

}
