package cn.e3mall.demo_1214.compress;

import org.xerial.snappy.Snappy;

import java.io.IOException;

/**
 * @ClassName: SnappyTest
 * @Auther: admin
 * @Date: 2019/12/19 14:41
 * @Description:
 */
public class SnappyTest {

    public static void main(String[] args) throws IOException {
        byte[] hellos = Snappy.compress("hello");
        System.out.println(hellos.length);
        System.out.println("hello".getBytes().length);

        System.out.println(Snappy.uncompressString(hellos));
    }

}
