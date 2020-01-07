package cn.e3mall.demo_1214.threadpool;

import java.util.function.Predicate;

public class Master {

    public static void main(String[] args) throws InterruptedException {
        MyThredPool myThredPool = new MyThredPool(5, 3);

        myThredPool.execute(new MyTask("1"));
        myThredPool.execute(new MyTask("4"));
        myThredPool.execute(new MyTask("5"));
        myThredPool.execute(new MyTask("54"));
        myThredPool.execute(new MyTask("45"));

        Thread.sleep(1000);

        System.out.println(myThredPool);
    }

    private static class MyTask implements Runnable{
        private String name;

        public MyTask() {
        }

        public MyTask(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("正在输出" + name);
        }
    }
}
