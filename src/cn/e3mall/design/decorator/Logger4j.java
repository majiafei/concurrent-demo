package cn.e3mall.design.decorator;

import javax.swing.*;

/**
 * @ProjectName: house
 * @Package: cn.e3mall.design.decorator
 * @ClassName: Logger4j
 * @Author: majiafei
 * @Description:
 * @Date: 2019/1/21 13:43
 */
public class Logger4j implements Logger {
    @Override
    public void info(String message) {
        System.out.println(message);
    }

    @Override
    public void error(String message) {
        System.out.println(message);
    }
}
