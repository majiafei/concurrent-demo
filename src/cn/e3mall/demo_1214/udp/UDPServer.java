package cn.e3mall.demo_1214.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 * @author majiafei
 * @date 2020/7/23 19:17
 */
public class UDPServer {

    private static final int MAX_LENGTH = 1024;

    private static DatagramSocket socket;

    public static void main(String[] args) {
        try {
            socket = new DatagramSocket(9999);

            byte[] buffer = new byte[MAX_LENGTH];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            // 接收客户端的消息
            socket.receive(packet);

            String message = new String(packet.getData(), 0, packet.getLength());
            System.out.println("接收到客户端的数据包：" + message);

            String responseStr = "我已经接收您发过来的消息";
            packet.setData(responseStr.getBytes());

            // 发送信息给客户端
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
