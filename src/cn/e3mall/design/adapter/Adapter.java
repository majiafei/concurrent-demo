package cn.e3mall.design.adapter;

/**
VGAInterface 被转换成的目标接口
 * @ProjectName: house
 * @Package: cn.e3mall.design.adapter
 * @ClassName: Adapter
 * @Author: majiafei
 * @Description:
 * @Date: 2019/1/22 10:11
 */
public class Adapter implements VGAInterface{
 
    // 被转换的接口
    private HDMIInterface hdmiInterface;

    public Adapter(HDMIInterface hdmiInterface) {
        this.hdmiInterface = hdmiInterface;
    }

    // 真正想要的格式
    @Override
    public void vga() {
        hdmiInterface.hdmi();
    }

}
