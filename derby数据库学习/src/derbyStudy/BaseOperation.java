package derbyStudy;

import java.sql.*;

/**
 * @Author DaWeiGuo
 * @Date 2020/8/24 9:40
 * @desc: derby简单更新、查询、删除操作。
 */
public class BaseOperation {
    public static void main(String[] args) throws SQLException {
        Connection con = null;
        Statement sql = null;
        ResultSet rs = null;
        String SQL = "";
        try{//加载驱动，建立连接。
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            con = DriverManager.getConnection("jdbc:derby:C:\\Users\\l1768\\Desktop\\Java_intellij idea\\derby数据库\\DemoFirst;create=false");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        try {//尝试建表
            sql = con.createStatement();
            SQL = "create table biao" + "(number char(10) primary key,name varchar(40),score float)";
            //Satement对象中的int excuteUpdate(String sql)方法和boolean excute(String sql)方法通过指定sql语句对表进行操作。
            sql.executeUpdate(SQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("该表已经存在！");
        }
        try{//对表进行插入、更新、查询操作
            SQL = "insert into biao values('B004','李刚',98),('B001','李强',97),('B003','李大强',97))";
            sql.executeUpdate(SQL);
            SQL = "update biao set score = 92,name = '李小四' where number ='B001'";
            sql.executeUpdate(SQL);
            rs = sql.executeQuery("select *from biao");
            while (rs.next()){
                String number = rs.getString(1);
                String name = rs.getString(2);
                float score = rs.getFloat(3);
                System.out.println(number+"\t\t"+name+"\t\t"+score);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            SQL = "update biao set score = 92,name = '李小四' where number ='B001'";
            sql.executeUpdate(SQL);
        }finally {//最后对修改后的表进行查询操作。
            rs = sql.executeQuery("select *from biao");
            while (rs.next()){
                String number = rs.getString(1);
                String name = rs.getString(2);
                float score = rs.getFloat(3);
                System.out.println(number+"\t\t"+name+"\t\t"+score);
            }
            con.close();
        }
    }
}
