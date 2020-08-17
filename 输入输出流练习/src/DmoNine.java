import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Scanner;

/**
 * @Author DaWeiGuo
 * @Date 2020/8/17 13:05
 * @desc: 文件锁：有时候会出现几个程序处理一个文件的情况,进行加锁的文件将无法进行操作。
 */
public class DmoNine {
    public static void main(String[] args){
        File file = new File("hello.txt");
        Scanner scanner = new Scanner(System.in);
        try{
            RandomAccessFile input = new RandomAccessFile(file,"rw");//以可读写的方式打开hello.txt文件
            FileChannel channel = input.getChannel();//input对象调用getChannel()方法获得一个连接底层文件的信道（FileChannel对象）
            FileLock lock = channel.tryLock();//通过信道对文件进行加锁，返回一个FileLock对象（文件锁），这一个过程称为对文件加锁
            System.out.println("输入要读取的行数：");
            while(scanner.hasNextInt()){//判断输入的数是否为整数。
                int m = scanner.nextInt();
                lock.release();//FileLock对象调用release()方法释放文件锁
                for(int i=1;i<=m;i++){
                    String str = input.readLine();//RandomAccessFile对象的readLine()读取中文会乱码
                    byte[] b = str.getBytes("iso-8859-1");
                    String s = new String(b);
                    System.out.println(s);
                }
                lock = channel.tryLock();
                System.out.println("输入要读取的行数：");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
