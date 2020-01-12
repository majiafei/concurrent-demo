package cn.e3mall.demo_1214.practice;

/**
 * 双重检查模式
 */
public class Singleton {

    // volatile防止指令重排
    private static volatile Singleton singleton;

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();

                    /**
                     * 对象实例化:
                     * 1.内存中分配空间
                     * 2.空间初始化
                     * 3.把空间的地址指给引用
                     */
                }
            }
        }

        return singleton;
    }

}
