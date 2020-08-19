package socketstudytwo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @Author DaWeiGuo
 * @Date 2020/8/19 8:25
 * @desc: 客户端 在套接字中使用多线程技术 （接收服务端返回的圆的面积）
 */
public class Cilent {
    public static void main(String[] args){
        Scanner scanner =new Scanner(System.in);
        Socket mysocket = null;
        DataInputStream in = null;
        DataOutputStream out = null;
        Thread readData;
        Read read = null;
        try{
            mysocket = new Socket();
            read = new Read();
            readData = new Thread(read);
            System.out.println("输入服务器的iP地址：");
            String ip = scanner.nextLine();
            System.out.println("输入端口：");
            int port = scanner.nextInt();
            if(mysocket.isConnected()){

            }
            else {//连接客户端
                InetAddress address = InetAddress.getByName(ip);
                //public void connect(Socket endpoint) throws IOException
                //InetSocketAddress是SocketAddress的子类 其构造方法是:public InetSocketAddress(InetAddress addr,int port)
                InetSocketAddress socketAddress = new InetSocketAddress(address,port);
                mysocket.connect(socketAddress);
                in = new DataInputStream(mysocket.getInputStream());
                out = new DataOutputStream(mysocket.getOutputStream());
                read.setDataInputStream(in);
                readData.start();//开启一个线程用来接收服务端返回的圆的面积，防止堵塞主线程
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("服务器连接已断开。");
        }
        System.out.println("输入圆的半径：（放弃输入N）");
        while (scanner.hasNext()){
            double radius = 0;
            try{
                radius = scanner.nextDouble();
                out.writeDouble(radius);
            }catch (InputMismatchException exp){
                System.exit(0);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
