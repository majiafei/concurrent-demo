package cn.e3mall.demo_1214.thread;

public class EndThread extends Thread {
    @Override
    public void run() {
        while (!interrupted()) {
            System.out.println(Thread.currentThread().getName());
        }
        System.out.println("interruped = " + isInterrupted());
    }


    public static void main(String[] args) throws InterruptedException {
        EndThread endThread = new EndThread();
        endThread.start();

        Thread.sleep(1000);
        endThread.interrupt();

        EndThread endThread2 = new EndThread();
        endThread2.start();
        endThread2.interrupt();
    }
}
