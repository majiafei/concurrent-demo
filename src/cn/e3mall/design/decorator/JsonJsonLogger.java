package cn.e3mall.design.decorator;

import java.lang.reflect.Method;

/**
 * @ProjectName: house
 * @Package: cn.e3mall.design.decorator
 * @ClassName: JsonJsonLogger
 * @Author: majiafei
 * @Description:
 * @Date: 2019/1/21 13:56
 */
public class JsonJsonLogger extends DecoratorLogger{

    public JsonJsonLogger(Logger logger) {
        super(logger);
    }

    @Override
    public void info(String message) {
        message = "{" + message + "}";
        logger.info(message);
    }

    @Override
    public void error(String message) {
        message = "{" + message + "}";
        logger.error(message);
    }

}
