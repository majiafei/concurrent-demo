package cn.e3mall.container;

import javax.xml.stream.events.StartDocument;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.*;

/**
 * @ProjectName: house
 * @Package: cn.e3mall.container
 * @ClassName: ArrayListAndVectorDemo
 * @Author: majiafei
 * @Description:
 * @Date: 2019/1/18 11:09
 */
public class ArrayListAndVectorDemo {

    private static Vector vector = new Vector();
    private static ThreadLocal<List<Integer>> list = new ThreadLocal<>();
    private static List arraylist = new ArrayList();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0;i<10;i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0;i<100;i++) {
                        vector.add(i);
                    }
                    System.out.println(Arrays.toString(vector.toArray()));
                }
            });
        }
        executorService.shutdown();

    }

    private static void addForVector() {
        for (int i = 0; i < 10; i++) {
            vector.add(i);
        }
    }

    private static void addForLIst() {
        for (int i = 0; i < 10; i++) {
        }
    }

}
