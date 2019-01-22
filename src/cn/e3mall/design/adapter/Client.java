package cn.e3mall.design.adapter;

/**
 * @ProjectName: house
 * @Package: cn.e3mall.design.adapter
 * @ClassName: Client
 * @Author: majiafei
 * @Description:
 * @Date: 2019/1/22 10:23
 */
public class Client {

    public static void main(String[] args) {
        HDMIInterface hdmiInterface = new HDMIImpl();
        Adapter adapter = new Adapter(hdmiInterface);
        adapter.vga();
    }
}
