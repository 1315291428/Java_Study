import java.io.*;

/**
 * @Author DaWeiGuo
 * @Date 2020/8/16 11:13
 * @desc: 数组流（流的源和目标除了是文件外，还可以是计算机内存）
 */
public class DemoSeven {
    public static void main(String[] args){
        try{
            //字节数组流
            ByteArrayOutputStream outByte = new ByteArrayOutputStream();//字节数组默认指向一个默认大小为32字节的缓冲区，参数size可以指定大小
            byte[] byteContent = "今天是2020年8月16号".getBytes();
            outByte.write(byteContent);
            //ByteArrayOutputStream对象的toByteArray()方法能返回输出流写入到缓冲区的全部字节
            ByteArrayInputStream inByte = new ByteArrayInputStream(outByte.toByteArray());
            byte[] backByte = new byte[outByte.toByteArray().length];
            inByte.read(backByte);//输入流将在缓冲区读取到的数据存放在backByte字节数组中
            System.out.println(new String(backByte));//调用String的构造方法将字节数组组合成字符串
            //字符数组流，与上面的字节数组流类似。
            CharArrayWriter outChar = new CharArrayWriter();
            char[] charContent = "数组流的练习啊".toCharArray();
            outChar.write(charContent);
            CharArrayReader inChar = new CharArrayReader(outChar.toCharArray());
            char[] backChar = new char[outChar.toCharArray().length];
            inChar.read(backChar);
            System.out.println(new String(backChar));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
