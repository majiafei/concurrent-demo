package cn.e3mall.demo_1214.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyThredPool {

    // 工作线程的数量
    private static int workerCount = 5;
    // 阻塞容器，存放任务
    private static BlockingQueue<Runnable> blockingQueue;
    private static int taskCount = 10;
    // 工作线程的容器
    private WorkerThread[] workerThreads;

    public MyThredPool() {
        this(taskCount, workerCount);
    }

    public MyThredPool(int taskCount, int workerCount) {
        if (taskCount > 0) {
            this.taskCount = taskCount;
        }
        if (workerCount > 0) {
            this.workerCount = workerCount;
        }
        blockingQueue = new LinkedBlockingQueue<>(taskCount);
        workerThreads = new WorkerThread[workerCount];

        for (int i = 0; i < workerCount; i++) {
            WorkerThread thread = new WorkerThread();
            workerThreads[i] = thread;
            thread.start();
        }
    }

    public void stop() {
        for (int i = 0; i < workerCount; i++) {
            workerThreads[i].stopWorker();
            workerThreads[i] = null;
        }
        blockingQueue.clear();
    }

    public void execute(Runnable runnable) {
        try {
            blockingQueue.put(runnable);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "task count " + blockingQueue.size();
    }

    private class WorkerThread extends Thread {
        @Override
        public void run() {
            try {
                Runnable runnable = null;
                while (!isInterrupted()) {
                    runnable = blockingQueue.take();
                    if (runnable != null) {
                        System.out.println(getId() + " ready execute " + runnable);
                        runnable.run();
                    }
                    runnable = null;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        /**
         * 中断线程，inter
         */
        public void stopWorker() {
            this.interrupt();
        }
    }


}
