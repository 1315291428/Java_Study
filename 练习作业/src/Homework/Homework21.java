package Homework;

/**
 * @Author DaWeiGuo
 * @Date 2020/7/16 16:55
 */
public class Homework21 {
    public static void main(String args[]){
        System.out.print(new PrimeNumber().allNum());
    }
}
class PrimeNumber{
    private  final int NUM = 200;
    public boolean judge(double x){
        boolean flag = false;
        double a = Math.sqrt(x);
        int i;
        for(i=2;i<=a;i++){
            if(x%i==0) break;
        }
        if(i>a){
            flag = true;
//            System.out.println("素数："+x);
            return flag;
        }
        else return flag;
    }
    public int allNum(){
        int sum = 0;
        for(int i=2;i<=this.NUM;i++){
            if(this.judge((double)i)) sum = sum + i;
        }
        return sum;
    }
}
