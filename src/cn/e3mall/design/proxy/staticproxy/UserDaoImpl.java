package cn.e3mall.design.proxy.staticproxy;

/**
 * @ProjectName: house
 * @Package: cn.e3mall.design.proxy.staticproxy
 * @ClassName: UserDaoImpl
 * @Author: majiafei
 * @Description:
 * @Date: 2019/1/21 16:48
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void addUser() {
        System.out.println("添加用户");
    }
}
