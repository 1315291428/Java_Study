package Homework;

import java.util.Scanner;

/**
 * @Author DaWeiGuo
 * @Date 2020/7/14
 */
public class Homework18 {
    public static void main(String args[]) {
        CarryGoods demo = new CarryGoods();
        demo.solve();
    }
}

class CarryGoods {
    final double BIG = 3;
    final double MID = 2;
    final double SMA = 0.5;
    private double n;

    CarryGoods() {
        this.n = new Scanner(System.in).nextDouble();
    }

    public void solve() {
        for (int big = 1; big <= this.n; big++) {//大马的数量
            double bigall = (big * BIG);//大马驮的包的数量
            double bigstill = this.n - bigall;//大马驮完剩下的数量
            for (int mid = 0; mid <= this.n - big; mid++) {//中马的数量
                double midall = (mid * MID);//中马驮的包的数量
                double midstill = bigstill - midall;//中马驮完剩下的数量
                if (midstill < 0) break;
                for (int sma = 2;sma<= this.n-mid-big; sma=sma+2){//小马的数量
                    if((sma*SMA+midall+bigall)==this.n&&(sma+mid+big)==this.n)//如果马的总和等于输入的数
                        System.out.printf("%d,%d,%d\n",big,mid,sma);          //且驮包数量的总和等于输入的数则输出
                }
            }
        }
    }
}
