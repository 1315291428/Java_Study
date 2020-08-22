package derbyStudy;

import java.sql.*;

/**
 * @Author DaWeiGuo
 * @Date 2020/8/22 11:40
 * @desc: derby基本查询操作。
 */
public class ConnectDerby {
    public static void main(String[] args){
        Connection con;
        Statement sql ;//声明一个sql语句对象。
        ResultSet resultset;
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");//加载数据库驱动;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try{
            //DriverManager.getConnection静态方法返回Connecttion连接对象。
            con = DriverManager.getConnection("jdbc:derby:C:\\Users\\l1768\\Desktop\\Java_intellij idea\\derby数据库\\DemoFirst;create=false");
            sql = con.createStatement();//Connect对象createStatement()方法创建一个sql语句对象。
            resultset =  sql.executeQuery("select *from room");//sql语句对象对数据库进行操作后返回一个ResultSet对象。
            while (resultset.next()){//ResultSet对象一次只能到一个数据行，使用next（）方法走到下一个数据行
                int id = resultset.getInt(1);//索引为列
                String s = resultset.getString(2);
                System.out.println("id:"+id+"  "+"name:"+s);
            }
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
