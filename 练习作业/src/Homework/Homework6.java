package Homework;

import java.util.Scanner;

public class Homework6 {
    public static void main(String args[]){
        Encryption demo = new Add4(new Scanner(System.in).next().charAt(0));
        demo.Letter();
    }
}
abstract class Encryption{
    abstract void Letter();
}
class Add4 extends Encryption{
    char a;
    Add4(char a){
        this.a = a;
    }
    public void Letter(){
        int index;
        index = (int)this.a;
        if(index<'a' || index>'z'){
            System.out.print(0);
        }
        else if(index >='w' && index <='z'){

            index  = 4 -('z' - index) + 'a' - 1;
            System.out.print((char)index);
        }
        else {
            index = index + 4;
            System.out.print((char)index);
        }

    }
}
