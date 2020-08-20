package UDPstudy;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * @Author DaWeiGuo
 * @Date 2020/8/20 10:49
 * @desc: Socket中UDP协议简单通信 （李四端） 代码解释见张三端
 */
public class LiSi {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Thread readData;
        ReceiveLetterForLi receiver = new ReceiveLetterForLi();
        try{
            readData = new Thread(receiver);
            readData.start();
            byte[] buffer = new byte[1];
            InetAddress address = InetAddress.getByName("127.0.0.1");
            DatagramPacket dataPack = new DatagramPacket(buffer,buffer.length,address,888);
            DatagramSocket postman = new DatagramSocket();
            System.out.print("输入发送给张三的信息：");
            while (scanner.hasNext()){
                String mess = scanner.nextLine();
                buffer = mess.getBytes();
                if(mess.length() == 0) System.exit(0);
                buffer = mess.getBytes();
                dataPack.setData(buffer);
                postman.send(dataPack);
                System.out.print("继续输入发送给张三的信息：");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
