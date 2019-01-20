package cn.e3mall.waitornotify;

/**
 * @ProjectName: house
 * @Package: cn.e3mall.waitornotify
 * @ClassName: Consumer
 * @Author: majiafei
 * @Description:
 * @Date: 2019/1/18 20:07
 */
public class Consumer implements Runnable {

    private ProductRepositry productRepositry;

    public Consumer(ProductRepositry productRepositry) {
        this.productRepositry = productRepositry;
    }

    @Override
    public void run() {
        while (true) {
            productRepositry.consume();
        }
    }
}
