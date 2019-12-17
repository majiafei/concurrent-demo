package cn.e3mall.demo_1214.thread;

public class VolatileTest{

    private static int number = 0;

    public static class PrintThread extends Thread{
        private ThreadLocal<String> threadLocal = new ThreadLocal<>();
        @Override
        public void run() {
            threadLocal.set(Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
                System.out.println("当前线程:" + Thread.currentThread().getName() + ":" + threadLocal.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        PrintThread printThread = new PrintThread();
        printThread.start();

        PrintThread printThread2 = new PrintThread();
        printThread2.start();
    }

}
