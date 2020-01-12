package cn.e3mall.demo_1214.practice;

/**
 * 懒汉式占位模式
 */
public class Singleton2 {



    private Singleton2() {}

    private static class InstanceHolder{
        private static Singleton2 singleton2 = new Singleton2();

        static {
            System.out.println("=============" + singleton2);
        }

        public InstanceHolder() {
            System.out.println("==============");
        }
    }

    public static Singleton2 getInstance() {
        return InstanceHolder.singleton2;
    }

    public static void main(String[] args) {
        Singleton2 singleton2 = new Singleton2();
        System.out.println(Singleton2.getInstance());
    }
}
