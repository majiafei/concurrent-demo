package cn.e3mall.design.singleton;

/**
 * @ProjectName: house
 * @Package: cn.e3mall.design.singleton
 * @ClassName: Singleton
 * @Author: majiafei
 * @Description:
 * <p>
 *     双重检查的单例模式(推荐使用)
 * </p>
 * @Date: 2019/1/21 10:02
 */
public class Singleton {

    private volatile static Singleton singleton;

    private Singleton() {}

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

}
