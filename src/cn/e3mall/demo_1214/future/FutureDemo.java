package cn.e3mall.demo_1214.future;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;

public class FutureDemo {

/*    public static void main(String[] args) {
//        Condition
//        FutureTask
    }*/

    public static void main(String[] args) {
        Map<Integer, String> ebayAccountMap = new HashMap<>();
        Map<Integer, Map<Integer, String>> platformAccountMap = new HashMap<>();
        platformAccountMap.put(new Integer(1), ebayAccountMap);
        ebayAccountMap.put(new Integer(1), "");
        ebayAccountMap = null;
        System.out.println(platformAccountMap);
    }

}
