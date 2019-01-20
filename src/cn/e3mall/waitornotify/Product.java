package cn.e3mall.waitornotify;

/**
 * @ProjectName: house
 * @Package: cn.e3mall.waitornotify
 * @ClassName: Product
 * @Author: majiafei
 * @Description:
 * @Date: 2019/1/18 19:47
 */
public class Product {

    private String name;
    private long productNo;

    public Product(String name, long productNo) {
        this.name = name;
        this.productNo = productNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getProductNo() {
        return productNo;
    }

    public void setProductNo(long productNo) {
        this.productNo = productNo;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", productNo=" + productNo +
                '}';
    }
}
