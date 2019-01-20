package cn.e3mall.clock;

/**
 * @ProjectName: house
 * @Package: cn.e3mall.clock
 * @ClassName: DeadClock
 * @Author: majiafei
 * @Description:
 * @Date: 2019/1/18 20:25
 */
public class DeadClock {

    public static void main(String[] args) {
        Object objectA = new Object();
        Object objectB = new Object();
        A a = new A(objectA, objectB);
        Thread t1 = new Thread(a);
        Thread t2 = new Thread(new B(objectA, objectB));
        t1.start();
        t2.start();
    }

    static class A implements Runnable{

        private Object objectA;
        private Object objectB;

        public A(Object objectA, Object objectB) {
            this.objectA = objectA;
            this.objectB = objectB;
        }

        @Override
        public void run() {
            synchronized (objectA) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (objectB) {
                    System.out.println("hello A");
                }
            }
        }
    }

    static class B implements Runnable {

        private Object objectA;
        private Object objectB;

        public B(Object objectA, Object objectB) {
            this.objectA = objectA;
            this.objectB = objectB;
        }

        @Override
        public void run() {
            synchronized (objectB) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (objectA) {
                    System.out.println("HEllo B");
                }
            }
        }
    }

}
