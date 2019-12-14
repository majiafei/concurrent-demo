package cn.e3mall.demo_1214.thread;

import java.util.concurrent.Callable;

public class ThreadTest {

    public static void main(String[] args) {
        new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("===============");
        }).start();

        RunnabelTest runnabelTest = new RunnabelTest();
        new Thread(runnabelTest).start();

    }

    private static class RunnabelTest implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread());
        }
    }

    private static class CallableTest implements Callable {

        @Override
        public Object call() throws Exception {
            return null;
        }
    }

}
