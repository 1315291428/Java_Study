package derbyStudy;

import java.sql.*;


/**
 * @Author DaWeiGuo
 * @Date 2020/8/25 16:11
 * @desc: 使用预处理语句（PrepareStatement对象），预处理sql语句会对sql语句进行预编译处理，生成数据库底层对的内部命令，
 *        会减轻SQL解释器的负担，提高运行速度。
 */
public class ReadySql {
    public static void main(String[] args){
        Connection con = null;
        PreparedStatement sta = null;
        ResultSet rs = null;
        String SQL = "";
        try{//加载驱动，建立连接。
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            con = DriverManager.getConnection("jdbc:derby:C:\\Users\\l1768\\Desktop\\Java_intellij idea\\derby数据库\\DemoFirst;create=false");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        try{
            SQL = "select *from biao";
            sta = con.prepareStatement(SQL);
            rs = sta.executeQuery();
            while (rs.next()){
                String number = rs.getString(1);
                String name = rs.getString(2);
                float score = rs.getFloat(3);
                System.out.println(number+"\t\t"+name+"\t\t"+score);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try{
            SQL = "insert into biao values (?,?,?)";//通配符?在预处理sql语句中按顺序分别称为第一个、第二个、第三个···第n个通配符。
            sta = con.prepareStatement(SQL);
            sta.setString(1,"a001");//按照通配符的顺序，依次为通配符设置具体的值
            sta.setString(2,"王小明");
            sta.setFloat(3, (float) 96.5);
            sta.executeUpdate();
            SQL = "select *from biao";
            sta = con.prepareStatement(SQL);
            rs = sta.executeQuery();
            while (rs.next()){
                String number = rs.getString(1);
                String name = rs.getString(2);
                float score = rs.getFloat(3);
                System.out.println(number+"\t\t"+name+"\t\t"+score);
            }
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
