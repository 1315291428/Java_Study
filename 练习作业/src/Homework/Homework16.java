package Homework;

import java.util.Scanner;

public class Homework16 {
    public static void main(String args[]){
        NumSum demo = new NumSum();
        System.out.print(demo.Nsum());
    }
}
class NumSum{
    private int n;
    NumSum(){
        Scanner input = new Scanner(System.in);
        this.n = input.nextInt();
    }
    public int Nsum(){
        int Nsum = 0;
        for(int i=1;i<=this.n;i++){
            Nsum = Nsum + this.sum(i);
        }
        return Nsum;
    }
    public int sum(int x){
//        System.out.println("本次是"+x+"项");
        int sum = 0;
        for(int i=1;i<=x;i++){
            sum = sum + i;
        }
//        System.out.println("和为："+sum);
        return sum;
    }
}

