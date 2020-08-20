package BroadCast;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author DaWeiGuo
 * @Date 2020/8/20 17:28
 * @desc: 多点套接字MulticastSocket的简单使用（广播端）
 */
public class Broadcast {
    int port = 5858;
    InetAddress group = null;
    MulticastSocket socket = null;//多点套接字
    Broadcast(){
        try{
            group = InetAddress.getByName("239.255.8.0");
            socket = new MulticastSocket(port);//设置多点套接字的广播端口
            socket.setTimeToLive(1);//设置广播范围为本地网络
            socket.joinGroup(group);//加入group后，广播的数据将被group中的成员接收到
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void play(){
        while (true){
            try{
                Date date = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("y/MM/d E H:m:s");
                String s = "现在的时间为："+dateFormat.format(date);
                DatagramPacket packet = null;
                byte[] data = s.getBytes();
                packet = new DatagramPacket(data,data.length,group,port);//待广播的数据包
                System.out.println(new String(data));
                socket.send(packet);//广播数据包
                Thread.sleep(2000);
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args){
        Broadcast demo = new Broadcast();
        demo.play();
    }
}
