package cn.e3mall.design.proxy.dymaticproxy;

/**
 * @ProjectName: house
 * @Package: cn.e3mall.design.proxy.dymaticproxy
 * @ClassName: Master
 * @Author: majiafei
 * @Description:
 * @Date: 2019/1/21 16:56
 */
public class Master {

    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        UserProxy userProxy = new UserProxy(userDao);
        UserDao userDao1 = (UserDao) userProxy.getProxy();
        userDao1.addUser();
    }

}
