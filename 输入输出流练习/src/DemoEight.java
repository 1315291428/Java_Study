import java.io.*;

/**
 * @Author DaWeiGuo
 * @Date 2020/8/16 11:52
 * @desc: 数据流 （这种流从文件中读取一个数值时，不必关心这个数值是多少字节）
 *        构造方法: DataInputStream(InputStream in) 创建的数据输入流指向一个由参数in指定的底层输入流
 *                DataOutputStream(OutputStream out) 创建的数据输出流指向一个由参数out指定的底层输出流
 */
public class DemoEight {//写几个java类型的数据到一个文件，然后读取出来
    public static void main(String[] args){
        File file = new File("DemoEight.txt");
        try{
            FileOutputStream fos = new FileOutputStream(file);//FileOutputStream是OutputStream的子类
            DataOutputStream outData = new DataOutputStream(fos);
            outData.writeInt(100);//写入一个整型数据
            outData.writeLong(123456L);//写入一个长整型数据
            outData.writeFloat(3.141592654f);//写入一个单精度浮点型数据
            outData.writeDouble(123456.123456);//写入一个双精度浮点型数据
            outData.writeBoolean(true);//写入一个布尔值
            outData.writeChars("数据流练习。");//写入一个字符串
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{//从文件中按顺序读取数值
            FileInputStream fis = new FileInputStream(file);//FileInputStream是InputStream的子类
            DataInputStream inData = new DataInputStream(fis);
            System.out.println(inData.readInt());
            System.out.println(inData.readLong());
            System.out.println(inData.readFloat());
            System.out.println(inData.readDouble());
            System.out.println(inData.readBoolean());
//            System.out.println(inData.readUTF());
            //UTF是双字节编码，而writeChars方法写入的是按照字符格式写入的，
            //在文件中的占位要小于以Unicode编码的同样字符串，所以，使用readUTF方法读取时，会出现EOF错误
            char c;//所以这里采用一个个读取字符的方法，直到字符串的结束符'\0'结束。
            while ((c=inData.readChar())!= '\0'){
                System.out.print(c);
            }
            inData.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
