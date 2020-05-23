package cn.e3mall.demo_1214.aqs;

import javax.swing.*;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * @ClassName: CyclicBarrier
 * @Auther: admin
 * @Date: 2020/3/3 17:41
 * @Description:
 */
public class CyclicBarrierTest {
    /*    */
    /**
     * 场景:有三个运动员一起比赛，其中一个准备好了，必须等待其他两个运动员准备好，比赛才能开始
     *//*
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 0, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(10));

    public static void main(String[] args) {
        Runner runner = new Runner("小明");
        Runner runner2 = new Runner("大明");
        Runner runner3 = new Runner("小大明");

        threadPoolExecutor.execute(runner);
        threadPoolExecutor.execute(runner2);
        threadPoolExecutor.execute(runner3);
    }

    static class Runner implements Runnable {

        private String name;

        public Runner(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                System.out.println(name + "开始准备");
                Thread.sleep(1000);
                System.out.println(name + "准备好了");

                cyclicBarrier.await();

                System.out.println(name + "开始跑步");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();

        Scanner scanner2 = new Scanner(System.in);
        String numStr = scanner2.nextLine();
        String[] priceStr = numStr.split(" ");
        if (Objects.isNull(priceStr)) {
            System.out.println("请输入价格");
            return;
        }
        if (priceStr.length != i) {
            System.out.println("请输入" + i + "个价格");
            return;
        }

        int[] priceArray = new int[priceStr.length];
        for (int m = 0; m < priceStr.length; m++) {
            try {
                int price = Integer.valueOf(priceStr[m]);
                if (price <= 0) {
                    System.out.println("第" + (i + 1) + "个价格不是正整数");
                    return;
                }
                if (price > 1000) {
                    System.out.println("第" + (i + 1) + "个价格必须小于等于1000");
                    return;
                }

                priceArray[m] = price;
            } catch (NumberFormatException e) {
                System.out.println("第" + (i + 1) + "个价格不是整数");
                return;
            }

        }

        int tem = 0;
        for (int m = 0; m < priceArray.length - 1; m++) {
            tem = priceArray[m];
            if (priceArray[m] > priceArray[m + 1]) {
                priceArray[m] = priceArray[m + 1];
                priceArray[m + 1] = tem;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        int th = priceArray[0];
        int count = 1;
        for (int m = 1; m < priceArray.length; m++) {
            if (priceArray[m] > th) {
                th = priceArray[m];
                count++;
                if (count == 3) {
                    break;
                }
            }
        }
        if (count == 3) {
            System.out.println(th);
        } else {
            System.out.println(-1);
        }
    }



}
