package socketstudytwo;

import java.io.*;

/**
 * @Author DaWeiGuo
 * @Date 2020/8/19 8:27
 * @desc:
 */
public class Read implements Runnable{
    DataInputStream in;
    public void setDataInputStream(DataInputStream in){
        this.in = in;
    }
    @Override
    public void run() {
        double result = 0;
        while (true){
            try{
                result = this.in.readDouble();
                System.out.println("圆的面积："+result);
                System.out.println("输入圆的半径：（放弃输入N）");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("与服务器的连接已断开。");
            }
        }
    }
}
