package cn.e3mall.demo_1214.syn;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author majiafei
 * @date 2020/9/4 21:41
 */
public class SysnchronizedTest {

    private static Lock lock = new Lock();

    public static void main(String[] args) throws InterruptedException {
//        System.out.println(Integer.toHexString(lock.hashCode()));
        System.out.println(ClassLayout.parseInstance(lock).toPrintable());

        Thread t1 = new Thread(() -> {
            test();
        });

        Thread t2 = new Thread(() -> {
            test();
        });

        t1.start();
        t1.join();

        t2.start();
    }

    private synchronized static void test() {
        System.out.println(ClassLayout.parseInstance(lock).toPrintable());
    }

}
