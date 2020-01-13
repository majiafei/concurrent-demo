package cn.e3mall.demo_1214.staticinner;

/**
 * <p>
 *     静态内部类加载的时机:在使用的时候才加载
 * </p>
 * @ClassName: StaticInnerTest
 * @Auther: admin
 * @Date: 2020/1/13 14:38
 * @Description:
 */
public class StaticInnerTest {

    private StaticInnerTest() {
        System.out.println("===============");
    }

    private StaticInnerTest(int i) {
        System.out.println("===============" + i);
    }

    static class A {
        public static StaticInnerTest staticInnerTest = new StaticInnerTest(3);

        static {
            System.out.println("sfjlsdfsdf");
        }
    }

    public static StaticInnerTest getInstance() {
        return A.staticInnerTest;
    }

    public static void main(String[] args) {
        StaticInnerTest staticInnerTest = getInstance();
    }

}
