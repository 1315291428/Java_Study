import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Author DaWeiGuo
 * @Date 2020/8/14 17:02
 * @desc: 文件字节输入流
 */
public class DemoOne {
    public static void main(String args[]) {
        int n = -1;
        byte[] a = new byte[100];
        try {
            File f = new File("hello.txt");
            FileInputStream in = new FileInputStream(f);
            while ((n = in.read(a, 0, 100)) != -1) {//off参数指定从字节数组的某个位置开始存放数据，
                //System.out.println("n:"+n);               //len参数是表明试图获取len个字节的内容
                String s = new String(a, 0, n);//字节数组创建字符串，offset指定数组的起始位置，读取n个字节
                System.out.print(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
