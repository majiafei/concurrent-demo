package cn.e3mall.demo_1214.container;

/**
 * @author majiafei
 * @date 2020/8/12 21:24
 */
public class HashMap {

    /**
     * 将cap变为2的n次方
     * @param cap
     */
    static final void tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
    }

    public static void main(String[] args) {
        tableSizeFor(100);
    }

}
