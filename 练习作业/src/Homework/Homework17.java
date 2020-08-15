package Homework;

import java.util.Scanner;

public class Homework17 {
    public static void main(String args[]){
        BackNum demo = new BackNum();
        demo.solve();
    }
}
class BackNum{
    private int inputnum;
    BackNum(){
        Scanner read = new Scanner(System.in);
        this.inputnum = read.nextInt();
        read.close();
    }
    public void solve(){
        String str = String.valueOf(this.inputnum);
        for(int i=str.length()-1;i>=0;i--){
            System.out.print(str.charAt(i));
        }
    }
}
