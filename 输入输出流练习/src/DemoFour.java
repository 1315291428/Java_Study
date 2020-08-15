import java.io.*;

/**
 * @Author DaWeiGuo
 * @Date 2020/8/15 10:02
 * @desc: 缓冲流 常用构造方法 |BufferedReader(Reader in); BufferedWriter(Writer out);|常称作上层流
 *              对象常用方法readLine()读取一行，newLine()新建一行
 */
public class DemoFour {
    public static void main(String args[]){
        File file = new File("DemoFour.txt");
        String content[] = {"商品列表:","电视机，2567元/台","洗衣机，3562RMB/台","冰箱，6573元/每台"};//要写入文件的内容
        try {
            FileWriter outOne = new FileWriter(file);
            BufferedWriter outTwo = new BufferedWriter(outOne);
            for(String str:content){
                outTwo.write(str);
                outTwo.newLine();//另起一行写入
            }
            outTwo.close();
            outOne.close();
            FileReader inOne = new FileReader(file);
            BufferedReader inTwo = new BufferedReader(inOne);
            String s = null;
            while ((s=inTwo.readLine())!=null){
                System.out.println(s);
            }
            inOne.close();
            inTwo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
