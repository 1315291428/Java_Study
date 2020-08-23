package query;

import java.sql.*;

/**
 * @Author DaWeiGuo
 * @Date 2020/8/23 9:00
 * @desc: derby简单查询操作
 */
public class Query {
    String databaseName = "C:\\Users\\l1768\\Desktop\\Java_intellij idea\\derby数据库\\DemoFirst";
    String SQL;
    String[] columnName;
    String [][] record;
    public Query(){
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");//加载驱动。
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void setDatabaseName(String s){
        this.databaseName = s.trim();//字符串的trim方法可去掉字符串首尾的空格。
    }
    public void setSQL(String SQL){
        this.SQL = SQL.trim();
    }
    public String[] getColumnName(){
        return this.columnName;
    }
    public String[][] getRecord(){
        return this.record;
    }
    public void startQuery(){
        Connection con;
        Statement sql;
        ResultSet rs;
        try {
            String uri = "jdbc:derby:"+databaseName;
            con = DriverManager.getConnection(uri);
            //createStatement方法中type的取值决定滚动方式，其值可以是：
            // - ResultSet.TYPE_SCROLL_ONLY:结果集的游标只能向下移动。
            // - ResultSet.TYPE_SCROLL_SENSITIVE:返回可滚动的数据集，当数据库变化时，结果集同步变化。
            // - ResultSet.TYPE_SCROLL_INSENSITIVE:结果集的游标可以上下移动，当数据库变化时，当前的结果集不变。
            // Concurrency 取值决定是否可以用结果集更新数据库，取值可以是：
            // - ResultSet.CONCUR_READ_ONLY:不能用结果集更新数据库的表。
            // - ResultSet.CONCUR_UPDATABLE:能用结果集更新数据库中的表。
            sql = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = sql.executeQuery(SQL);//执行sql语句返回ResultSet对象。
            //ResultSet对象调用getMetaData()方法返回ResultSetMetaData对象（元数据对象）
            ResultSetMetaData metaData = rs.getMetaData();
            //ResultSetMetaData对象调用getColumnCount返回字段的列数
            int columnCount = metaData.getColumnCount();
            columnName = new String[columnCount];
            for(int i=1;i<=columnCount;i++){
                columnName[i-1] = metaData.getColumnName(i);//ResultSetMetaData对象调用getColumnName返回字符串形式的字段名。
            }
            rs.last();
            int recordAmount = rs.getRow();//返回游标指向的当前行数。
            record = new String[recordAmount][columnCount];
            int i = 0;
            rs.beforeFirst();//将游标移动到第一行之前。
            while (rs.next()){
                for(int j=1;j<=columnCount;j++){
                    record[i][j-1] = rs.getString(j);
                }
                i++;
            }
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
