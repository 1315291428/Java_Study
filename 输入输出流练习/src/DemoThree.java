import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author DaWeiGuo
 * @Date 2020/8/15 9:41
 * @desc: 文件字符流,常用构造方法 FileReader/FileWriter(String filename); FileReader/FileWriter(File filename);
 *                            FileReader/FileWriter(String filename,boolean append);
 */
public class DemoThree {
    public static void main(String args[]){
        String content = "文件字符流练习";
        try{
           File f = new File("DemoThree.txt");//创建File对象
           char a [] = content.toCharArray();
            FileWriter out = new FileWriter(f);//创建字符输出流对象
            StringBuffer s = new StringBuffer();
            out.write(a,0,a.length);//写入目标文件
            out.close();//关闭字符输出流
            FileReader in = new FileReader(f);//创建字符输入流对象
            char tom[] = new char[10];
            int n = -1;
            while ((n=in.read(tom,0,10))!= -1){
                String temp = new String(tom,0,n);//String类字符数组构建字符串
                s.append(temp);//StringBuffer对象的append方法将字符串拼接在末尾
            }
            in.close();//关闭字符输入流
            System.out.println(s);
            //System.out.println(new String(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
