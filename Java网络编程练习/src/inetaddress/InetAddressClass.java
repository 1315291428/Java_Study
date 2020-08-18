package inetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author DaWeiGuo
 * @Date 2020/8/18 10:26
 * @desc: InetAddress类 一个InetAddress的对象含有一个Internet主机地址的域名和IP地址。
 */
public class InetAddressClass {
    public static void main(String[] args){
        try{//InetAddress类还有两个实例方法分别是：
            // - public String getHostName():获取InetAddress对象所含的域名。
            // - public String getHostAddress():获取InetAddress对象所含的ip地址。
            //InetAddress的静态方法getLocalHost()可以获取含有本机域名和ip地址的InetAddress对象。
            InetAddress addressOne =InetAddress.getByName("www.baidu.com");//getByName是InetAddress的静态方法\
            System.out.println("baidu的域名："+addressOne.getHostName());   //传入的参数一个字符串形式的域名或ip地址
            System.out.println(addressOne.toString());
            InetAddress addressLocal =InetAddress.getLocalHost();
            System.out.println("本机的域名和IP地址："+addressLocal.toString());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
