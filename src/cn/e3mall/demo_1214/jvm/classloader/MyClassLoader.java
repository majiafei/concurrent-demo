package cn.e3mall.demo_1214.jvm.classloader;

import cn.e3mall.demo_1214.jvm.ClassLoaderOrder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author majiafei
 * @date 2020/8/11 17:30
 */
public class MyClassLoader {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
//                return super.loadClass(name);
                 String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                InputStream resourceAsStream = getClass().getResourceAsStream(fileName);
                if (resourceAsStream == null) {
                    return super.loadClass(name);
                }


                    byte[] b = new byte[resourceAsStream.available()];
                    resourceAsStream.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return super.loadClass(name);
            }
        };

        Object obj = classLoader.loadClass("cn.e3mall.demo_1214.jvm.classloader.MyClassLoader").newInstance();
        System.out.println(obj.getClass());
        // 虚拟机中存在两个MyClassLoader类，一个是由自定义的类加载加载的，另一个是由应用程序类加载加载的
        // 类加载器：虚拟机团队把类加载过程中"根据类的全限定名获取类的二进制字节流"这个过程放到外面实现，又应用程序
        // 自己决定如何加载所需要的类，这个动作的代码块叫做类加载器。
        System.out.println(obj instanceof MyClassLoader);
    }
}
