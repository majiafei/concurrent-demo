package cn.e3mall.container;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ProjectName: house
 * @Package: cn.e3mall.container
 * @ClassName: HashMapDemo
 * @Author: majiafei
 * @Description:
 * @Date: 2019/1/18 12:26
 */
public class HashMapDemo {

/*    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Map map = new HashMap();
        for (int i = 0; i < 1000000; i++) {
            map.put(i+"", i);
        }
        System.out.println(System.currentTimeMillis() - start);

        TreeMap treeMap = new TreeMap();
        start = System.currentTimeMillis();
        for (int i = 0; i<1000000; i++) {
            treeMap.put(""+i, i);
        }
        System.out.println(System.currentTimeMillis() - start);

        LinkedHashMap linkedHashMap = new LinkedHashMap();
        start = System.currentTimeMillis();
        for (int i = 0; i<1000000; i++) {
            linkedHashMap.put(""+i, i);
        }
        System.out.println(System.currentTimeMillis() - start);
    }*/

    public static void main(String[] args) {
        /*HashMap<String, String> map = new HashMap<String, String>();

        map.put("a3", "aa");

        map.put("a2", "bb");

        map.put("b1", "cc");

        for (Iterator iterator = map.values().iterator(); iterator.hasNext();)     {

            String name = (String) iterator.next();

            System.out.println(name);

        }

        HashMap<String, String> map1 = new LinkedHashMap<String, String>();

        map1.put("a3", "aa");

        map1.put("a2", "bb");

        map1.put("b1", "cc");
        map1.get("xxx");

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.putIfAbsent("xx", "ddd");
        concurrentHashMap.get("xxx");
        concurrentHashMap.size();

        System.out.println(((2) & ~2) == 0);

        *//*for (Iterator iterator = map1.values().iterator(); iterator.hasNext();) {

            String name = (String) iterator.next();

            System.out.println(name);

        }*//*

        HashSet hashSet = new HashSet();
        hashSet.add("xxx");*/

        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(1, 1);
        linkedHashMap.put(0, 0);

        for (Map.Entry<Integer, Integer> entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey());
        }

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(1, 1);
        treeMap.put(0, 0);

        /**
         * 0
         * 1
         */
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey());
        }

        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        reentrantLock.tryLock();
        reentrantLock.unlock();

        HashMap hashMap = new HashMap();
        hashMap.put("xxx", "xxxx");
    }

}
