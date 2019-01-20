package cn.e3mall.volatiledemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ProjectName: house
 * @Package: cn.e3mall.volatiledemo
 * @ClassName: VolatileDemo
 * @Author: majiafei
 * @Description:
 * @Date: 2019/1/18 20:40
 */
public class VolatileDemo {
    private volatile   static boolean ready;
    private volatile   static int number;
    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while(!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }
    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            new ReaderThread().start();
        }
        number = 42;
        ready = true;

    }

}
