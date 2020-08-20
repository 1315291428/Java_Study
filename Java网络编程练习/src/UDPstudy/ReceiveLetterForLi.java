package UDPstudy;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @Author DaWeiGuo
 * @Date 2020/8/20 10:47
 * @desc: Socket中UDP协议简单通信 （此代码用于李四接受信息） 代码解释见张三端
 */
public class ReceiveLetterForLi implements Runnable{
    @Override
    public void run() {
        DatagramPacket pack = null;
        DatagramSocket postman = null;
        byte data[] = new byte[8192];
        try{
            pack = new DatagramPacket(data,data.length);
            postman = new DatagramSocket(666);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        while (true){
            if(postman == null) break;
            else{
                try {
                    postman.receive(pack);
                    String message = new String(pack.getData(),0,pack.getLength());
                    System.out.printf("%25s\n","收到："+message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
