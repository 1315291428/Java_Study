package socketstudyone;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author DaWeiGuo
 * @Date 2020/8/18 11:35
 * @desc: 简单socket服务端
 */
public class Server {
    public static void main(String[] args){
        String[] answers = {"DaWeiGuo","Changde Hunan China","19"};
        ServerSocket sever = null;
        Socket onSever = null;
        DataOutputStream out = null;
        DataInputStream in = null;
        try{
            sever = new ServerSocket(2010);//构造方法ServerSocket(int port)服务端只用指定端口。
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            System.out.println("等待客户端呼叫：");
            //accept()方法会阻塞线程，直至接受到客户端的请求，建立起和客户端的连接
            //该方法返回一个和客户端Socket对象相连接的Socket对象，完成后，将继续执行下面的操作
            onSever = sever.accept();
            in = new DataInputStream(onSever.getInputStream());
            out = new DataOutputStream(onSever.getOutputStream());
            System.out.println(in.readUTF());
            for(int i=0;i< answers.length;i++){
                String s = in.readUTF();
                System.out.println("服务端收到的提问："+s);
                out.writeUTF(answers[i]);
                Thread.sleep(500);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
