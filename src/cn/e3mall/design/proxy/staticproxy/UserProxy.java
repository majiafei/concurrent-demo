package cn.e3mall.design.proxy.staticproxy;

/**
 * @ProjectName: house
 * @Package: cn.e3mall.design.proxy.staticproxy
 * @ClassName: UserProxy
 * @Author: majiafei
 * @Description:
 * @Date: 2019/1/21 16:49
 */
public class UserProxy implements  UserDao{

    private UserDao userDao;

    public UserProxy(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser() {
        System.out.println("准备添加用户");
        userDao.addUser();
        System.out.println("添加用户完成");
    }
}
