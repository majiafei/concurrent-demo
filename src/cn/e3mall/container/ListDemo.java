package cn.e3mall.container;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ProjectName: house
 * @Package: cn.e3mall.container
 * @ClassName: ListDemo
 * @Author: majiafei
 * @Description:
 * @Date: 2019/1/18 10:38
 */
public class ListDemo {

    private static List<Integer> arrayList = new ArrayList<>();
    private static List<Integer> linkedList = new LinkedList<>();

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                addForLinkedList();
                deeleteForLinkedList();
                insertForLinkedList();
            }
        });
        thread.start();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                addForArrayList();
                insertForArrayList();
                deeleteForArraylist();
            }
        });
        t2.start();
    }

    private  static void addForArrayList() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            arrayList.add(i);
        }
        System.out.println("addForArrayList花了" + (System.currentTimeMillis() - start));
    }

    private static void addForLinkedList() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            linkedList.add(i);
        }
        System.out.println("addForLinkedList花了" + (System.currentTimeMillis() - start));
    }

    private static void deeleteForArraylist() {
        long start = System.currentTimeMillis();
        arrayList.remove(1000);
        System.out.println("deeleteForArraylist花了" + (System.currentTimeMillis() - start));
    }

    private static void deeleteForLinkedList() {
        long start = System.currentTimeMillis();
        linkedList.remove(1000);
        System.out.println("deeleteForLinkedList花了" + (System.currentTimeMillis() - start));
    }

    private static void insertForArrayList() {
        long start = System.currentTimeMillis();
        arrayList.add(1000, 0);
        System.out.println("insertForArrayList花费了" + (System.currentTimeMillis() - start));
    }

    private static void insertForLinkedList() {
        long start = System.currentTimeMillis();
        linkedList.add(1000, 0);
        System.out.println("iinsertForLinkedList花费了" + (System.currentTimeMillis() - start));
    }



}
