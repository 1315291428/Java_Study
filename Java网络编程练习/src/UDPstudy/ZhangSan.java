package UDPstudy;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * @Author DaWeiGuo
 * @Date 2020/8/20 10:17
 * @desc: Socket中UDP协议简单通信 (张三端)
 */
public class ZhangSan {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Thread readData;
        ReceiveLetterForZhang receiver = new ReceiveLetterForZhang();
        try{
            readData = new Thread(receiver);
            readData.start();//开启张三用于接收信息的线程。
            byte[] buffer = new byte[1];
            InetAddress address = InetAddress.getByName("127.0.0.1");
            //DatagramPacket类的两个构造方法：
            // - DatagramPacket(byte[] data,int length,InetAddress address,int port);
            //上述方法将数据data发送到地址为address，端口为port的主机上
            // - DatagramPacket(byte[] data,int offset,int length,InetAddress address,int port);
            //上述方法将数据data从offset截取length个字节发送到地址为address，端口为port的主机上
            //DatagramPacket对象的常用方法：getPort()返回端口，getAddress()返回地址，getData()返回数据包中的字节数组
            DatagramPacket dataPack = new DatagramPacket(buffer,buffer.length,address,666);
            DatagramSocket postman = new DatagramSocket();//DatagramSocket无参构造方法创造的对象可用于发送信息 （37行）
            System.out.print("输入发送给李四的信息：");
            while (scanner.hasNext()){
                String mess = scanner.nextLine();
                buffer = mess.getBytes();
                if(mess.length() == 0) System.exit(0);
                buffer = mess.getBytes();
                dataPack.setData(buffer);
                postman.send(dataPack);
                System.out.print("继续输入发送给李四的信息：");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
