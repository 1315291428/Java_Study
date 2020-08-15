package Homework;

import java.util.Scanner;

public class Homework8 {
    public static void main(String args[]){
        Solve demo = new Solve(new Scanner(System.in).nextInt());
        demo.function();
    }
}
class Solve{
    private double b = 0;
    private int a;
    private int i = 1;
    Solve(int a){
        this.a = a;
    }
    public void function(){
        while (this.i<=this.a){
            if(this.i%2 == 0){
                this.b =  (-(1/(double)this.i)) + this.b;
            }
            else {
                this.b =  (1/(double)this.i) + this.b;
            }
            this.i = this.i + 1;
        }
        System.out.printf("%.6f",this.b);
    }
}