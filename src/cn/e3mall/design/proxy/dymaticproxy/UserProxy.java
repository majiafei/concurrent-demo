package cn.e3mall.design.proxy.dymaticproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ProjectName: house
 * @Package: cn.e3mall.design.proxy.dymaticproxy
 * @ClassName: UserProxy
 * @Author: majiafei
 * @Description:
 * <p>
 *     动态代理
 * </p>
 * @Date: 2019/1/21 16:53
 */
public class UserProxy implements InvocationHandler {

    private Object targetObject;

    public UserProxy(Object targetObject) {
        this.targetObject = targetObject;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("准备添加用户");
        Object invoke = method.invoke(targetObject, args);
        System.out.println("添加用户完成");
        return invoke;
    }
}
