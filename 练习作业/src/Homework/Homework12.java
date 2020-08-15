package Homework;

import java.util.Scanner;

public class Homework12 {
    public static void main(String args[]){
        Demo d = new Demo();
        d.fun();
    }
}
class Demo{
    public void fun(){
        int n,i,r,z=1,q=0,m;
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        for (i=2;i<=n;i++)
        {  z=1;
            for (m=2;m<i;m++)
            {
                r=i%m;
                if (r==0) {z=0;break;}
            }
            if (z!=0) q++;
        }
        System.out.print(q);
    }
}