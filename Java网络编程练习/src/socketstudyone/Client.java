package socketstudyone;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @Author DaWeiGuo
 * @Date 2020/8/18 11:14
 * @desc: 简单socket客户端
 */
public class Client {//客户端
    public static void main(String[] args){
        String[] mess = {"你是谁？","你来自那里？","多大？"};
        try{
            //构造方法Socket(String host,int port) 参数host指定服务器ip地址，port指定端口。
            Socket mysocket = new Socket("127.0.0.1",2010);
            //从将建立的socket连接中获取输入流成为数据流的输入流，简单来说就是接受服务端发送的信息。
            DataInputStream in = new DataInputStream(mysocket.getInputStream());
            //从将建立的socket连接中获取输出流流成为数据流的输出流，简单来说就是向服务端发送信息。
            DataOutputStream out = new DataOutputStream(mysocket.getOutputStream());
            out.writeUTF("DaWeiGuo客户端呼叫。");//发送信息
            for(int i=0;i< mess.length;i++){
                out.writeUTF(mess[i]);
                String s = in.readUTF();//接受信息
                System.out.println("客户端收到的回答是："+s);
                Thread.sleep(500);//主线程休眠0.5秒。
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
