import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @Author DaWeiGuo
 * @Date 2020/8/15 14:13
 * @desc: RandomAccessFile类创建的流称为随机流，两个构造方法：RandomAccessFile(String name,String mode);
 *                                                      RandomAccessFile(File file,String mode);
 *                                                      mode参数取 r（只读） rw（可读写）
 */
public class DemoFive {
    public static void main(String args[]){
        RandomAccessFile inAndOut = null;
        int data[] = {1,2,3,4,5,6,7,8,9,10};
        try{
            inAndOut = new RandomAccessFile("DemoFive.dat","rw");//以可读写的方式打开文件
            for(int i=0;i<data.length;i++){
                inAndOut.writeInt(data[i]);
            }
            for(long i=data.length-1;i>=0;i--){//一个int类型数据占据4个字节，inAndOut从第36个字节的位置读取最后面的一个整数
                inAndOut.seek(i*4);//seek(long a);该方法用定位RandomAccessFile流的读写位置，参数a确立读写位置距离文件开头的字节个数
                System.out.printf("\t %d ",inAndOut.readInt());//每隔四个字节往前读取一个整数
            }
            inAndOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
