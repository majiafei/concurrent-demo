package cn.e3mall.demo_1214.concurrent;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName: ConcurrentHashMapTest
 * @Auther: admin
 * @Date: 2020/3/13 17:24
 * @Description:
 */
public class ConcurrentHashMapTest {

    public static void main(String[] args) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("3", "0");
    }

}
