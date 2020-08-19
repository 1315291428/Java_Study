package socketstudytwo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author DaWeiGuo
 * @Date 2020/8/19 9:17
 * @desc: 服务器端（接收客户端的输入的圆的半径，计算出面积后返回给客户端）。
 */
public class Server {
    public static void main(String[] args){
        ServerSocket server = null;
        ServerThread thread;
        Socket you = null;
        while (true){//为每个客户开通一个线程
            try{
                server = new ServerSocket(2010);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("正在监听。");
            }
            try{
                System.out.println("等待客户端呼叫：");
                you = server.accept();
                System.out.println("已接通，客户的地址"+you.getInetAddress());
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("正在等待客户：");
            }
            if(you!=null){
                new ServerThread(you).start();
            }
        }
    }
}
class ServerThread extends Thread{
    Socket socket;
    DataOutputStream out = null;
    DataInputStream in = null;
    String s = null;
    ServerThread(Socket t){
        this.socket = t;
        try {
            out = new DataOutputStream(t.getOutputStream());
            in = new DataInputStream(t.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void run(){
        while (true){//读取客户端发送过来的圆的半径并计算出面积，返回给客户端
            try {
                double r = in.readDouble();
                double area = Math.PI*r*r;
                out.writeDouble(area);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("客户离开。");
                return;
            }
        }
    }
}