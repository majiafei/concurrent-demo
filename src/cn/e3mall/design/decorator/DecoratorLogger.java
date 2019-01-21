package cn.e3mall.design.decorator;

/**
 * @ProjectName: house
 * @Package: cn.e3mall.design.decorator
 * @ClassName: DecoratorLogger
 * @Author: majiafei
 * @Description:
 * @Date: 2019/1/21 13:47
 */
public abstract class DecoratorLogger  implements Logger{

    protected Logger logger;

    public DecoratorLogger(Logger logger) {
        this.logger = logger;
    }

}
