package Homework;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author DaWeiGuo
 * @Date 2020/7/14 18:07
 */
public class homework19 {
    public static void main(String args[]){
        new FindNum();
    }
}
class FindNum{
    private int inputnum;
    private int array[] = new int[20];
    FindNum(){
        Scanner read = new Scanner(System.in);
        this.inputnum = read.nextInt();
        read.close();
        this.array[0] = 0;
        this.array[1] = 1;
        this.array[2] = 1;
        for(int i=3;i<this.array.length;i++){
            this.array[i] = this.array[i-1]+this.array[i-2]+this.array[i-3];
        }
        this.InNumFindNum(this.array);
    }
    public void InNumFindNum(int a[]){
        Arrays.sort(a);
        int result = Arrays.binarySearch(a,this.inputnum);
        if(result>=0)
        System.out.print(result);
        else System.out.print(-1);
    }

}