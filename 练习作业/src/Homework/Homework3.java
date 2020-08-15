package Homework;

import java.util.Scanner;

public class Homework3 {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        Rectangle rectangle1 = new Rectangle();
        rectangle1.setL(input.nextDouble());
        rectangle1.setW(input.nextDouble());
        System.out.printf("%.2f",rectangle1.fs());
    }
}
class Rectangle{
    private double l;
    private double w;
    Rectangle(){

    }
    public void setW(double w){
        this.w = w;
    }
    public double getW(){
        return this.w;
    }
    public void setL(double l){
        this.l = l;
    }
    public double getL(){
        return this.l;
    }
    public double fs(){
        return this.l * this.w;
    }
}