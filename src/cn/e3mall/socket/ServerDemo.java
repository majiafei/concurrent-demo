package cn.e3mall.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ProjectName: house
 * @Package: cn.e3mall.socket
 * @ClassName: ServerDemo
 * @Author: majiafei
 * @Description:
 * @Date: 2019/1/18 16:52
 */
public class ServerDemo {

/*    public static void main(String[] args) throws IOException {
        // 创建服务端套接字
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务端已经启动，等待客户端连接");
        // 监听客户端的连接
        Socket socket = serverSocket.accept();
        // 获取输入流，即客户端发送的请求信息
        InputStream inputStream = socket.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String info = "";
        String temp = null;
        if ((temp = bufferedReader.readLine()) != null) {
            info = info + temp;
        }
        System.out.println("客户端请求的请求信息如下:" + info);

        // 给客户端发送消息
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter printWriter = new PrintWriter(outputStream);
        printWriter.write("你好，服务端已经接收到您的信息");
        printWriter.flush();
        socket.shutdownOutput();// 关闭输出流

        printWriter.close();
        outputStream.close();
        bufferedReader.close();
        inputStream.close();
        socket.close();


    }*/

    private static int j = 0;

    public static void main(String[] args) throws IOException {
        // 监听指定的端口
        int port = 55538;
        ServerSocket server = new ServerSocket(port);

        // server将一直等待连接的到来
        System.out.println("server将一直等待连接的到来");

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {

            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    Socket socket = null;
                    while (true) {
                        StringBuilder sb = new StringBuilder();
                        j++;
                        try {
                            socket = server.accept();
                            // 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
                            InputStream inputStream = socket.getInputStream();
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                            String temp = null;
                            while ((temp = bufferedReader.readLine()) != null) {
                                sb.append(temp);
                            }
                            System.out.println(Thread.currentThread().getName() + "：get message from client: " + sb);
                            bufferedReader.close();
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }

}
