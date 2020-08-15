package Homework;


import java.util.Scanner;

public class Homework7 {
    public static void main(String args[]){
        APassWord demo = new CrackPwd();
        demo.pwd();
    }
}
abstract class APassWord{
    abstract void pwd();
}
class CrackPwd extends APassWord{
    private int n1;
    private int n2;
    int s;
    int m;
    int i;
    boolean flag = true;
    public void pwd(){
        Scanner input = new Scanner(System.in);
        this.n1 = input.nextInt();
        this.n2 = input.nextInt();
        input.close();
        for(i=n1;i<n2;i++){
            String str = String.valueOf(i);
            s = 0;
            m = 1;
            for(int j=0;j<str.length();j++){
                s = Integer.valueOf(Character.toString(str.charAt(j))) + s;
                m = Integer.valueOf(Character.toString(str.charAt(j))) * m;
            }
            if(s == m){
                System.out.println(i);
                flag = false;
            }

        }
        if(flag) {
            System.out.println(0);
        }
    }
}