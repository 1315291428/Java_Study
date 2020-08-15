package Homework;

import java.util.Scanner;

public class Homework15 {
    public static void main(String args[]){
        Crawl demo = new Crawl();
        demo.solve();
    }
}
class Crawl{
    private int h;
    private int m;
    private int n;
    Crawl(){
        Scanner input = new Scanner(System.in);
        this.h = input.nextInt();
        this.m = input.nextInt();
        this.n = input.nextInt();
        input.close();
    }
    public void solve(){
        int i;
        int crawllongth = 0;
//        int dark = this.m - this.n;
        for(i=1;;i++){
//            int index =this.m;
            crawllongth = this.m + crawllongth;
//            System.out.println("第"+i+"天"+"爬了"+index+"总计"+crawllongth);
            if(crawllongth>=this.h) break;
            crawllongth = crawllongth - this.n;
        }
        System.out.print(i);
    }
}