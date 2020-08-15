package Homework;

import java.util.Scanner;

public class Homework5 {
    public static void main(String args[]){
        Loan demo = new Pay(new Scanner(System.in).nextDouble());
        demo.purchaseHome();

    }
}
abstract class Loan{
    abstract void purchaseHome();
}
class Pay extends Loan{
    final double p = 5000;
    private double d;
    final double r = 0.004;
    private double m;
    Pay(double d){
        this.d = d;
    }
    public void purchaseHome(){
        this.m = ((Math.log(p) - Math.log(p - this.d * r)) / Math.log(1 + r));
        System.out.printf("%.2f",this.m);
    }

}