package cn.e3mall.demo_1214.thread;

/**
 * @ClassName: InterruptThred
 * @Auther: admin
 * @Date: 2020/5/14 09:17
 * @Description:
 */
public class InterruptThred extends Thread{

    @Override
    public void run() {
        // 当前的线程是否被中断，（第一次调用这个方法后，会清除标记位，假设第一次调用的时候返回true，那么第二次调用的时候会返回false）
        while (!Thread.interrupted()) {
            System.out.println(Thread.currentThread().getName() + ":hello===================");
        }
        System.out.println(Thread.currentThread().getName() + "被中断");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (!Thread.interrupted()) { // 这是第二次调用，除非在这之前又将线程给中断了，否则返回false
            System.out.println(Thread.currentThread().getName() + "线程又恢复了");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        InterruptThred interruptThred = new InterruptThred();
        interruptThred.start();

        Thread.sleep(500);
        interruptThred.interrupt();

    }

}
