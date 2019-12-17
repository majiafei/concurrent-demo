package cn.e3mall.demo_1214.thread;

public class EndThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getName() + "========================");
    }


    public static void main(String[] args) throws InterruptedException {
        EndThread endThread = new EndThread();
        endThread.start();
        endThread.join();

        EndThread endThread2 = new EndThread();
        endThread2.start();
    }
}
