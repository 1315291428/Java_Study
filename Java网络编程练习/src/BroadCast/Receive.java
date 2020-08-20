package BroadCast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * @Author DaWeiGuo
 * @Date 2020/8/20 18:13
 * @desc: 多点套接字MulticastSocket的简单使用（接收端）
 */
public class Receive {
    public static void main(String[] args){
        int port = 5858;//设置接收广播的端口。
        InetAddress address = null;
        MulticastSocket socket = null;
        try{
            address = InetAddress.getByName("239.255.8.0");
            socket = new MulticastSocket(port);
            socket.joinGroup(address);//加入group
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true){
            byte[] data = new byte[8192];
            DatagramPacket packet =null;
            packet = new DatagramPacket(data,data.length,address,port);//待接收的数据包
            try{
                socket.receive(packet);
                String messages = new String(packet.getData(),0,packet.getLength());
                System.out.println("收到的信息为："+messages);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
