package Homework;

import java.util.Scanner;

/*题目描述
        一个小球从100米高度自由落下，每次落地后反弹回原来高度的0.618倍，再落下，再反弹。计算它在第n次落地时共经过多少米？

        输入格式
        一整数n

        输出格式
        一个小数，保留2位小数
*/
public class Homework11 {
    public static void main(String args[]){
        ReboundBall demo = new ReboundBall();
        demo.solveLong();
    }
}
class ReboundBall{
    private int nbottom;
    private double longth = 0;
    private double height = 100;
    ReboundBall(){
        Scanner input = new Scanner(System.in);
        this.nbottom = input.nextInt();
        input.close();
    }

    public void setNbottom(int nbottom) {
        this.nbottom = nbottom;
    }

    public int getNbottom() {
        return nbottom;
    }
    public void solveLong(){
        for(int i=1;i<=this.nbottom;i++){
            if(i>1)
            this.height = this.height * 0.618;
            this.longth = this.longth + height*2;
        }
        this.longth = this.longth - 100;
        System.out.printf("%3.2f",this.longth);
    }
}