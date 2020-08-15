package Homework;

import java.util.Scanner;

/**
 * @Author DaWeiGuo
 * @Date 2020/7/16 16:44
 * 凯撒密码
 */
public class Homework20 {
    public static void main(String args[]){
        Password demo = new Password();
        demo.encryption();
    }
}
class Password{
    private String string;
    private char a[];
    Password(){
        this.string = new Scanner(System.in).nextLine();
        this.a = this.string.toCharArray();
    }
    public void encryption(){
        for(int i=0;i<a.length;i++){
            if(Character.isAlphabetic(a[i])){
                a[i] = (char)((int)a[i]+4);
            }
        }
        for(char i:a){
            System.out.print(i);
        }
    }
}