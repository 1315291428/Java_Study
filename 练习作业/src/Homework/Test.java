package Homework;

import java.util.Scanner;

public class Test{
    public static void main(String[] args) {
        SortThreeNumbers stn=new SortThreeNumbers();
        stn.inputNumbers();
        stn.min();
        stn.outputMin();
    }
}
class SortThreeNumbers {

    int a,b,c;
    void inputNumbers() {
        Scanner readerScanner=new Scanner(System.in);
        a=readerScanner.nextInt();
        b=readerScanner.nextInt();
        c=readerScanner.nextInt();
        readerScanner.close();
    }
    void min(){
        if(a>b) {
            int temp=a;
            a=b;
            b=temp;
        }
        if(a>c) {
            int temp=a;
            a=c;
            c=temp;
        }
        if(b>c) {
            int temp=a;
            a=c;
            c=temp;
        }
    }
    void outputMin(){
        System.out.printf("%d", a);
    }
}