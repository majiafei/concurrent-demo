package cn.e3mall.demo_1214.lock;

/**
 * @ClassName: MySelfLockTest
 * @Auther: admin
 * @Date: 2019/12/20 17:33
 * @Description:
 */
public class MySelfLockTest {

    private static MySelfLock mySelfLock = new MySelfLock();

    public static void hello() {
        mySelfLock.lock();
        try {
            System.out.println("======================" + Thread.currentThread());
            System.out.println(Thread.currentThread());
        } finally {
            mySelfLock.release();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                hello();
            }).start();
        }
    }

}
