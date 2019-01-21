package cn.e3mall.design.proxy.staticproxy;

/**
 * @ProjectName: house
 * @Package: cn.e3mall.design.proxy.staticproxy
 * @ClassName: Master
 * @Author: majiafei
 * @Description:
 * @Date: 2019/1/21 16:51
 */
public class Master {

    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        userDao.addUser();
        UserProxy userProxy = new UserProxy(userDao);
        userProxy.addUser();
    }

}
