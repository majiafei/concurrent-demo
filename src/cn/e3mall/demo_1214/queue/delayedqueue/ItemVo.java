package cn.e3mall.demo_1214.queue.delayedqueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class ItemVo<T> implements Delayed {

    // 过期的时长
    private long activeTime;
   // 存储的数据
    private T data;

    public ItemVo(long expireTime, T data) {
        this.activeTime = expireTime * 1000 + System.currentTimeMillis();
        this.data = data;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.activeTime - System.currentTimeMillis(), unit);
    }

    @Override
    public int compareTo(Delayed o) {
        long differ =  this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS);
        if (differ < 0) {
            return -1;
        } else if (differ > 0) {
            return 1;
        }
        return 0;
    }

    public long getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(long activeTime) {
        this.activeTime = activeTime;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
