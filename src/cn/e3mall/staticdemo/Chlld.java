package cn.e3mall.staticdemo;

/**
 * @ProjectName: house
 * @Package: cn.e3mall.staticdemo
 * @ClassName: Chlld
 * @Author: majiafei
 * @Description:
 * @Date: 2019/1/21 9:52
 */
public class Chlld extends Parent {

    static Foo foo = new Foo("child的静态参数");

    Foo foo2 = new Foo("child的普通的实例变量");

    static {
        System.out.println("child的静态快");
    }

    {
        System.out.println("child的代码块");
    }

    public Chlld() {
        System.out.println("child的构造函数");
    }
}
