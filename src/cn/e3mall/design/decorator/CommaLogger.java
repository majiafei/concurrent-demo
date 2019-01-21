package cn.e3mall.design.decorator;

/**
 * @ProjectName: house
 * @Package: cn.e3mall.design.decorator
 * @ClassName: CommaLogger
 * @Author: majiafei
 * @Description:
 * @Date: 2019/1/21 14:03
 */
public class CommaLogger extends DecoratorLogger {
    public CommaLogger(Logger logger) {
        super(logger);
    }

    @Override
    public void info(String message) {
        message = message + ":";
        logger.info(message);
    }

    @Override
    public void error(String message) {
        message = message + ":";
        logger.error(message);
    }
}
