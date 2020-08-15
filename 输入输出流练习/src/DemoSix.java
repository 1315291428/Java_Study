import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @Author DaWeiGuo
 * @Date 2020/8/15 16:50
 * @desc: RandomAccessFile流的readLine()方法读取含有非 ascii字符文件时会出现乱码，此代码为解决方法
 */
public class DemoSix {
    public static void main(String args[]) {
        try{
            RandomAccessFile in = new RandomAccessFile("DemoFour.txt","rw");
            long lenth = in.length();//in.length()方法获取文件的长度
            long position = 0;
            in.seek(position);//seek()设置文件的读取位置，这里定位的文件的起始位置
            while (position<lenth){
                String str = in.readLine();
//                System.out.println("未经过处理的字符串"+str);//这样直接输出会乱码
                byte b[] = str.getBytes("iso-8859-1");
                str = new String(b);//19、20行代码等同于String content = new String(b,"GB2312")直接指定编码组建字符串
                position = in.getFilePointer();//获取目前读取的位置                        //#这里假定读写的文件是GB2312编码#
                System.out.println(str);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
