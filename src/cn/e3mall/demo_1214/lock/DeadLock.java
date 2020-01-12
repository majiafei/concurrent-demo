package cn.e3mall.demo_1214.lock;

public class DeadLock {

    private static class MyThread extends Thread {
        private Object firstLock;
        private Object secondLock;

        public MyThread(Object firstLock, Object secondLock) {
            this.firstLock = firstLock;
            this.secondLock= secondLock;
        }

        @Override
        public void run() {
            synchronized (firstLock) {
                System.out.println(Thread.currentThread().getName() + " get " + firstLock);
                synchronized (secondLock) {
                    System.out.println(Thread.currentThread().getName() + " get " + secondLock);
                }
            }
        }
    }

    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();

        Thread t1 = new MyThread(obj1, obj2);
        Thread t2 = new MyThread(obj2, obj1);

        t1.start();
        t2.start();
    }

}
