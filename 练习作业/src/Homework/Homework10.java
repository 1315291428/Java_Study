package Homework;

import java.util.Arrays;
import java.util.Scanner;

public class Homework10 {
    public static void main(String args[]){
        new Maxstone().findStone();
    }
}
class Maxstone{
    private int araay[] = new int[10];
    int i = 0;
    int flag;
    Maxstone(){
        Scanner input = new Scanner(System.in);
        for(i=0;i<this.araay.length;i++){
            this.araay[i] = input.nextInt();
            }
        input.close();
    }
    public void findStone(){
        int copyarray[] = Arrays.copyOf(this.araay,10);
        Arrays.sort(copyarray);
        int max = copyarray[9];
//        int index = Arrays.binarySearch(this.araay,max);
        int index;
        for(i=0;i<this.araay.length;i++){
            if(araay[i] == max){
                flag = i;
            }
        }
        int temp = this.araay[flag];
        this.araay[flag] = this.araay[0];
        this.araay[0] = temp;
        for(int a:this.araay){
            System.out.print(a+" ");
        }
    }
}