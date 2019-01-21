package cn.e3mall.staticdemo;

/**
 * @ProjectName: house
 * @Package: cn.e3mall.staticdemo
 * @ClassName: Parent
 * @Author: majiafei
 * @Description:
 * @Date: 2019/1/21 9:49
 */
public class Parent {

    static Foo foo = new Foo("Parent的是static parameter");

    Foo foo2 = new Foo("Parent的普通的实例变量");

    static {
        System.out.println("Parent的静态块");
    }

    {
        System.out.println("parent的代码块");
    }

    public Parent() {
        System.out.println("parent的构造方法");
    }

}
