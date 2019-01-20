package cn.e3mall.waitornotify;

/**
 * @ProjectName: house
 * @Package: cn.e3mall.waitornotify
 * @ClassName: Producer
 * @Author: majiafei
 * @Description:
 * @Date: 2019/1/18 20:05
 */
public class Producer implements Runnable {

    private ProductRepositry productRepositry;

    public Producer(ProductRepositry productRepositry) {
         this.productRepositry = productRepositry;
    }

    @Override
    public void run() {
        while (true) {
            productRepositry.produce();
        }
    }

}
