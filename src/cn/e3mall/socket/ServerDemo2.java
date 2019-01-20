package cn.e3mall.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ProjectName: house
 * @Package: cn.e3mall.socket
 * @ClassName: ServerDemo2
 * @Author: majiafei
 * @Description:
 * @Date: 2019/1/18 17:41
 */
public class ServerDemo2 {

    private volatile static int j = 0;

    public static void main(String[] args) throws IOException {
        // 监听指定的端口
        int port = 55534;
        ServerSocket server = new ServerSocket(port);

        // server将一直等待连接的到来
        System.out.println("server将一直等待连接的到来");

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        long start = System.currentTimeMillis();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                Socket socket = null;
                while (true) {
                    try {
                        socket = server.accept();
                        // 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
                        InputStream inputStream = socket.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                        String temp = null;
                        StringBuilder sb = new StringBuilder();
                        while ((temp = bufferedReader.readLine()) != null) {
                            sb.append(temp);
                        }
                        System.out.println(Thread.currentThread().getName() + "：get message from client: " + sb);
                        if (sb.equals("20")) {
                            break;
                        }
                        bufferedReader.close();
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (j == 10) {

                    }
                }
            }
        });
    }

}
