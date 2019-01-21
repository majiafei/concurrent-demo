package cn.e3mall.design.decorator;

/**
 * @ProjectName: house
 * @Package: cn.e3mall.design.decorator
 * @ClassName: LoggerFacotry
 * @Author: majiafei
 * @Description:
 * @Date: 2019/1/21 13:45
 */
public class LoggerFacotry {

    public static Logger getLogger() {
        return new Logger4j();
    }

    public static Logger getJsonLogger() {
        return new JsonLogger(getLogger());
    }

}
