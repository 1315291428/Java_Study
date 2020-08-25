package derbyStudy;

import java.sql.*;

/**
 * @Author DaWeiGuo
 * @Date 2020/8/25 16:30
 * @desc: Java中jdbc的事务处理类似于python的Django框架中对数据库进行操作的会话形式。
 *        简单来说就是一个事务中的sql语句不会立即执行对数据库进行操作，而是对数据库的操作记录在相应的对象中，
 *        事务完成后，再通过commit提交这个对象将要对数据库操作，完成一次对数据库的更新或者查询操作。
 */
public class Session {
    public static void main(String[] args){
        Connection con = null;
        Statement sql;
        ResultSet rs;
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try{
            double n = 500;
            String uri = "jdbc:derby:C:\\Users\\l1768\\Desktop\\Java_intellij idea\\derby数据库\\DemoFirst;create=false";
            con = DriverManager.getConnection(uri);
            con.setAutoCommit(false);
            sql = con.createStatement();
//            sql.executeUpdate("insert into biao values ('c001','李强',100)");
            sql.executeUpdate("update biao set name = '李小三' where number = 'c001'");
            con.commit();
            rs = sql.executeQuery("select *from biao");
            while (rs.next()){
                String number = rs.getString(1);
                String name = rs.getString(2);
                float score = rs.getFloat(3);
                System.out.println(number+"\t\t"+name+"\t\t"+score);
            }
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
