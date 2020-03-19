package cn.e3mall.demo_1214.jvm;

/**
 * @ClassName: ClassLoaderOrder
 * @Auther: admin
 * @Date: 2020/3/19 09:15
 * @Description:
 */
public class ClassLoaderOrder {

    private static class Parent {
        public static int a  = 1;

        static {
            a = 2;
        }

        public Parent() {
            System.out.println("初始化父类");
        }
    }

    private static class Sub extends Parent{
        private static int b = a;

        public Sub() {
            System.out.println("初始化子类");
        }
    }

    public static void main(String[] args) {
        System.out.println(Sub.b);
    }

}
