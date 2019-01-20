package cn.e3mall.socket;

import javax.swing.*;
import java.io.*;
import java.net.Socket;

/**
 * @ProjectName: house
 * @Package: cn.e3mall.socket
 * @ClassName: ClientDemo
 * @Author: majiafei
 * @Description:
 * @Date: 2019/1/18 17:01
 */
public class ClientDemo {

   /* public static void main(String[] args) throws IOException {
        Socket socket = null;
        OutputStream outputStream = null;
        PrintWriter printWriter = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
            // 与服务端建立连接
            socket = new Socket("localhost", 8888);
            // 获取输出流，向服务端写入信息
            outputStream = socket.getOutputStream();
            printWriter = new PrintWriter(outputStream);
            printWriter.write("服务端，您好，我想与您建立连接");
            printWriter.flush();
            socket.shutdownInput();// 关闭输出流

            // 获取输入流
            inputStream = socket.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            String temp = null;
            String info = "";
            while ((temp = bufferedReader.readLine()) != null) {
                info = info + temp;
            }
            System.out.println("服务端发送的信息如下：" + info);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            printWriter.close();
            outputStream.close();
            socket.close();
        }
    }
*/
   public static void main(String[] args) throws IOException {
       // 要连接的服务端IP地址和端口
       String host = "127.0.0.1";
       int port = 55534;
       for (int i = 0; i < 200000; i++) {
           // 与服务端建立连接
           Socket socket = new Socket("localhost", port);
           // 建立连接后获得输出流
           OutputStream outputStream = socket.getOutputStream();
           String message="你好  yiwangzhibujian";
           socket.getOutputStream().write((message).getBytes());
           outputStream.close();
       }
   }
}


