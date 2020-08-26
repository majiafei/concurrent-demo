package cn.e3mall.demo_1214.container;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * <p>
 *     测试ArrayList的不安全性
 * </p>
 * @ClassName: ArrayListTest
 * @Auther: admin
 * @Date: 2019/12/18 15:31
 * @Description:
 */
public class ArrayListTest {

    private static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
/*        // 验证arraylist的不安全性
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString());
            }).start();
        }

        Thread.sleep(1000);

        System.out.println(list);*/

        List<String> l = list;
        list.add("xxx");

        System.out.println(l.size());

    }

}
