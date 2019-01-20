package cn.e3mall.blockqueue;

/**
 * @ProjectName: house
 * @Package: cn.e3mall.blockqueue
 * @ClassName: Product
 * @Author: majiafei
 * @Description:
 * @Date: 2019/1/20 10:40
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
