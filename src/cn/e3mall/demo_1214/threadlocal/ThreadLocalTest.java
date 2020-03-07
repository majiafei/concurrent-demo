package cn.e3mall.demo_1214.threadlocal;

/**
 * @ClassName: ThreadLocalTest
 * @Auther: admin
 * @Date: 2020/3/4 17:03
 * @Description:
 */
public class ThreadLocalTest {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set("xxxxxxx");
    }

}
