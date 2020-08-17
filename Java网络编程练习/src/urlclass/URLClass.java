package urlclass;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @Author DaWeiGuo
 * @Date 2020/8/17 16:34
 * @desc: 读取url中的资源
 */
public class URLClass {
    public static void main(String[] args){
        try{
            URL url = new URL("http://www.baidu.com");//https协议会出现证书问题
            InputStream in = url.openStream();//URL对象调用openStream()方法返回一个输入流，该输入流可以将网络资源读取到程序当中
            byte[] b = new byte[1024];
            int n = -1;
            while ((n=in.read(b))!=-1){
                String str = new String(b,0,n);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
