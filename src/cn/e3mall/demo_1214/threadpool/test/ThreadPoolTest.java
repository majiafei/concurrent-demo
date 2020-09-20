package cn.e3mall.demo_1214.threadpool.test;

import com.sun.org.apache.bcel.internal.generic.NEWARRAY;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author majiafei
 * @date 2020/9/20 21:57
 */
public class ThreadPoolTest {

    private static final ThreadPoolExecutor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(5, 5, 0, TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<>(100));

    public static void main(String[] args) {
        List<String> nameList = new ArrayList<>();
        nameList.add("xiaoming");
        nameList.add("hyson");

        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < nameList.size(); i++) {
            int temp = i;
            THREAD_POOL_EXECUTOR.submit(() -> {
                for (int j = 0; j <= 100; j++) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(100);
                        map.put(nameList.get(temp),  "[" + j + "%]");
                        System.out.print("\r" + map);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

}
