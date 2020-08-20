package UDPstudy;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @Author DaWeiGuo
 * @Date 2020/8/20 10:20
 * @desc: Socket中UDP协议简单通信 （此代码用于张三接受信息）
 */
public class ReceiveLetterForZhang implements Runnable{
    @Override
    public void run() {
        DatagramPacket pack = null;
        DatagramSocket postman = null;//DatagramSocket无参构造方法创造的对象也可用于接受信息，但需要指定端口（21行） 接收信息（29行）
        byte data[] = new byte[8192];
        try{
            pack = new DatagramPacket(data,data.length);
            postman = new DatagramSocket(888);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        while (true){
            if(postman == null) break;
            else{
                try {
                    postman.receive(pack);
                    //getData()返回数据包中的字节数组，getLength()返回数据包中字节数组的长度
                    String message = new String(pack.getData(),0,pack.getLength());
                    System.out.printf("%25s\n","收到："+message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
