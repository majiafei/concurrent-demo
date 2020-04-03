package cn.e3mall.demo_1214.extendss;

/**
 * @ClassName: Children
 * @Auther: admin
 * @Date: 2020/4/3 14:14
 * @Description:
 */
public class Children extends Parent {

    public Children() {
        System.out.println("child");
    }

    public static void main(String[] args) {
        System.out.println(new Children());
    }
}
