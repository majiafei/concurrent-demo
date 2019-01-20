package cn.e3mall.container;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

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
        Map<String, String> map = new HashMap<String, String>();

        map.put("a3", "aa");

        map.put("a2", "bb");

        map.put("b1", "cc");

        for (Iterator iterator = map.values().iterator(); iterator.hasNext();)     {

            String name = (String) iterator.next();

            System.out.println(name);

        }

        Map<String, String> map1 = new LinkedHashMap<String, String>();

        map1.put("a3", "aa");

        map1.put("a2", "bb");

        map1.put("b1", "cc");

        for (Iterator iterator = map1.values().iterator(); iterator.hasNext();) {

            String name = (String) iterator.next();

            System.out.println(name);

        }
    }

}
