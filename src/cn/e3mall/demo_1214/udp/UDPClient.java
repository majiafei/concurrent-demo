package cn.e3mall.demo_1214.udp;

import java.io.IOException;
import java.net.*;

/**
 * @author majiafei
 * @date 2020/7/23 19:43
 */
public class UDPClient {

    public static void main(String[] args) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket();

            byte[] bytes = "hello".getBytes();
            InetAddress byName = InetAddress.getByName("127.0.0.1");
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, byName, 9999);

            datagramSocket.send(packet);

            // 接收服务端的信息
            byte[] receiveBytes = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(receiveBytes, receiveBytes.length);

            datagramSocket.receive(datagramPacket);

            String str = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
            System.out.println("获取到服务端的信息为：" + str);
            System.out.println("获取到服务端的地址为：" + datagramPacket.getAddress());
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
