package cn.e3mall.demo_1214.queue.delayedqueue;

import java.math.BigDecimal;

public class Order {

    private String orderId;

    public Order() {
    }

    public Order(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
