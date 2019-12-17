package cn.e3mall.demo_1214.thread;

public class SyncTest{

    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        CountTest countTest = new CountTest();

        Thread t1 = new Thread(countTest);
        t1.start();

        CountTest countTest2 = new CountTest();
        Thread t2 = new Thread(countTest2);
        t2.start();

        Thread.sleep(2000);
        System.out.println(count);
    }

    private static class CountTest implements Runnable {

        @Override
        public void run() {
            count();
        }

        private  void count() {
            synchronized (CountTest.class) {
                for (int i = 0; i < 10000; i++) {
                    count++;
                }
                System.out.println(count);
            }
        }
    }

}
