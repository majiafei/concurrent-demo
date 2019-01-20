package cn.e3mall.waitornotify.demo1;

/**
 * @ProjectName: house
 * @Package: cn.e3mall.waitornotify.demo1
 * @ClassName: Master
 * @Author: majiafei
 * @Description:
 * <p>
 *     子线程先执行10次，主线程执行5次，子线程再执行10次，主线程再执行5次，如此反复3次
 * </p>
 * @Date: 2019/1/20 11:31
 */
public class Master {

    public static void main(String[] args) {
        Master master = new Master();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                master.exeSub();
            }
        });
        thread.start();
        master.exeMain();
    }

    private synchronized  void  exeMain() {
        for (int i = 0; i < 3; i++) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int j = 0; j < 10; j++) {
                System.out.println(Thread.currentThread().getName() + "执行" + j);
            }
            this.notify();
        }
    }

    private synchronized void exeSub() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println(Thread.currentThread().getName() + "执行" + j);
            }
            this.notify();
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
