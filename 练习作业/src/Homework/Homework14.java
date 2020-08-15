package Homework;

import java.util.Scanner;

public class Homework14 {
    public static void main(String args[]){
        FractionalSequence demo = new FractionalSequence();
        demo.sumSolve();
    }
}
class FractionalSequence{
    private int inputNum;
    FractionalSequence(){
        Scanner input = new Scanner(System.in);
        this.inputNum = input.nextInt();
        input.close();
    }
    public void sumSolve(){
        int index = 1;
        double sum = 0;
        double item ;
        int top = 2;
        int bot = 1;
        int rem;
        while (true){
//            System.out.println("第"+index+"项"+"分子："+top+"\t分母:"+bot);
            item = (double) top/bot;
            sum = sum + item;
            rem = top;
            top = top + bot;
            bot = rem;
            if(index == this.inputNum) break;
            index++;
        }
        System.out.printf("%.2f",sum);

    }
}
