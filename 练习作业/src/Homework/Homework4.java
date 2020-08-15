package Homework;

import java.util.Scanner;

public class Homework4 {
    public static void main(String args[]){
        int input;
        int s=0,m=1;
        Scanner read = new Scanner(System.in);
        input = read.nextInt();
        String str = String.valueOf(input);
        System.out.println(Integer.parseInt((Character.toString(str.charAt(0)))));
        for(int i=0;i<3;i++){
            s = Integer.valueOf(Character.toString(str.charAt(i))) + s;
            m = Integer.valueOf(Character.toString(str.charAt(i))) * m;
        }
        System.out.printf("%d %d",s,m);
    }
}
