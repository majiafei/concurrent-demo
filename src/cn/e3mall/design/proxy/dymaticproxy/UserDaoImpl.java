package cn.e3mall.design.proxy.dymaticproxy;

/**
 * @ProjectName: house
 * @Package: cn.e3mall.design.proxy.dymaticproxy
 * @ClassName: UserDaoImpl
 * @Author: majiafei
 * @Description:
 * @Date: 2019/1/21 16:53
 */
public class UserDaoImpl implements UserDao {

    @Override
    public void addUser() {
        System.out.println("添加用户");
    }
}
