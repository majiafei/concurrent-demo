package cn.e3mall.design.decorator;

/**
 * @ProjectName: house
 * @Package: cn.e3mall.design.decorator
 * @ClassName: Master
 * @Author: majiafei
 * @Description:
 * @Date: 2019/1/21 13:45
 */
public class Master {

    public static void main(String[] args) {
        JsonLogger jsonLogger = new JsonLogger(new Logger4j());
        CommaLogger commaLogger = new CommaLogger(jsonLogger);
        commaLogger.info("你好");
    }

}
