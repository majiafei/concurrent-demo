package cn.e3mall.demo_1214.jvm.gc;

/**
 * @author majiafei
 * @date 2020/8/11 14:50
 */
public class TestGC {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] byte1 = new byte[1];
        byte[] byte2 = new byte[4 * _1MB];
        byte[] byte3 = new byte[4 * _1MB];
        byte3 = null;
        byte3 = new byte[6 * _1MB];
    }

}
