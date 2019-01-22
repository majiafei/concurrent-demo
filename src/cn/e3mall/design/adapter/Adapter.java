package cn.e3mall.design.adapter;

/**
 * @ProjectName: house
 * @Package: cn.e3mall.design.adapter
 * @ClassName: Adapter
 * @Author: majiafei
 * @Description:
 * @Date: 2019/1/22 10:11
 */
public class Adapter implements VGAInterface{

    private HDMIInterface hdmiInterface;

    public Adapter(HDMIInterface hdmiInterface) {
        this.hdmiInterface = hdmiInterface;
    }

    @Override
    public void vga() {
        hdmiInterface.hdmi();
    }

}
