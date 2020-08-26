package cn.e3mall.demo_1214.container;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author majiafei
 * @date 2020/8/12 17:36
 */
public class LinkedListTest {

    public static void main(String[] args) {
        ArrayList<String> linkedList = new ArrayList<>();
        linkedList.add("xxx");

        for (String str : linkedList) {
        }

        ArrayList<String> s1 = linkedList;

        linkedList = new ArrayList<>();
        System.out.println(s1.size());
    }

}
