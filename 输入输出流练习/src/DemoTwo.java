import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author DaWeiGuo
 * @Date 2020/8/14 17:40
 * @desc: 文件字节输出流
 */
public class DemoTwo {
    public static void main(String[] args){
        byte [] a = "今天是2020年8月14号\n".getBytes();
        byte [] b = "是DaWeiGuo的java文件字节输出流的练习啊".getBytes();
        try{
            FileOutputStream out = new FileOutputStream("DemoTwo输出流.txt");//可选参数append为true在文件末尾写入，
            out.write(a);//写入一个字节数组。                                        //false则刷新文件从头写入(默认为false)
            out.write(b,0,b.length);//写入一个字节数组，off参数指定写入的起始位置，第三个参数指定写入的长度。
            out.close();//关闭输出流。
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

