package cn.e3mall.demo_1214.lock;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @ClassName: MySelfLock
 * @Auther: admin
 * @Date: 2019/12/20 17:12
 * @Description:
 */
public class MySelfLock {

    private MySync mySync = new MySync();

    private class MySync extends AbstractQueuedSynchronizer {
        @Override
        protected boolean tryAcquire(int arg) {
            int currentState = getState();
            if (currentState == 0) {
                if (compareAndSetState(0, arg)) {
                    setExclusiveOwnerThread(Thread.currentThread());
                    return true;
                }
            } else {
                if (getExclusiveOwnerThread() == Thread.currentThread()) {
                    int nextc = currentState + arg;
                    if (nextc < 0) // overflow
                        throw new Error("Maximum lock count exceeded");
                    setState(nextc); // 只可能有一个线程进入这里，就是当前获得锁的线程
                    return true;
                }
            }

            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            if (Thread.currentThread() != getExclusiveOwnerThread()) {
                throw new RuntimeException("非当前持有锁的线程来释放锁");
            }

            boolean free = false;
            int c = getState() - arg;
            if (c == 0) {
                setExclusiveOwnerThread(null);
                free = true;
            }

            setState(c);
            return free;
        }

        public void lock() {
            if (compareAndSetState(0,  1)) {
                setExclusiveOwnerThread(Thread.currentThread());
            } else {
                acquire(1);
            }
        }
    }

    public void lock() {
        mySync.lock();
    }

    public void release() {
        mySync.release(1);
    }

}
