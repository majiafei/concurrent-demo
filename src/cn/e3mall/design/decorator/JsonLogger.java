package cn.e3mall.design.decorator;


/**
 * @ProjectName: house
 * @Package: cn.e3mall.design.decorator
 * @ClassName: JsonLogger
 * @Author: majiafei
 * @Description:
 * @Date: 2019/1/21 13:48
 */
public class JsonLogger extends DecoratorLogger {

    public JsonLogger(Logger logger) {
        super(logger);
    }

    @Override
    public void info(String message) {
        message = transform(message);
        this.logger.info(message);
    }

    @Override
    public void error(String message) {
        message = transform(message);
        this.logger.info(message);
    }

    private String transform(String message) {
        message = "{" + message + "}";
        return message;
    }

}
