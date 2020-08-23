package query;

/**
 * @Author DaWeiGuo
 * @Date 2020/8/23 9:00
 * @desc: derby简单查询操作
 */
public class DemoOne {
    public static void main(String[] args){
        Query query = new Query();
        query.setSQL("select *from room");//设置查询的sql语句。
        query.startQuery();
        String ziduan[] = query.getColumnName();//获取字段名。
        for(String s:ziduan){
            System.out.print(s+"\t\t");
        }
        System.out.println();
        String[][] record = query.getRecord();//以行列的方式获取值
        int rows = record.length;
        for(int i=0;i<rows;i++){
            for(String s:record[i]){
                System.out.print(s+"\t\t");
            }
            System.out.println();
        }
    }
}
