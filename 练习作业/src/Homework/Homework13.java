package Homework;

import java.util.Scanner;

/*完全数（Perfect number），又称完美数或完备数，是一些特殊的自然数。它所有的真因子（即除了自身以外的约数）的和（即因子函数），恰好等于它本身。 如果一个数恰好等于它的因子之和，则称该数为“完全数”。第一个完全数是6，第二个完全数是28，第三个完全数是496，后面的完全数还有8128、33550336等等。

        题目描述
        统计1~n之间完全数的个数。n为一个自然数。*/
public class Homework13 {
    public static void main(String args[]){
        PerfectNumber demo = new PerfectNumber();
        demo.perfectNumberAll();
//        demo.judge(496);
    }
}
class PerfectNumber{
    private int n;
    PerfectNumber(){
        Scanner input = new Scanner(System.in);
        this.n = input.nextInt();
        input.close();
    }
    public boolean judge(int x){
        int sum = 0;
        for(int i=1;i<x;i++){
            if(x%i==0){
                sum = sum+i;
            }
        }
//        System.out.println("和为："+sum+"\tx为："+x);
        if(sum==x) { return true;}
        else return false;
    }
    public void perfectNumberAll(){
        int sumNum = 0;
        for(int i=1;i<this.n;i++){
            if(this.judge(i)){
                sumNum++;
            }
        }
        System.out.println(sumNum);
    }
}
