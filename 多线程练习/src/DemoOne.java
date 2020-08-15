/**
 * @Author DaWeiGuo
 * @Date 2020/8/13 10:31
 * @desc: 通过继承Thread类创建线程
 */
public class DemoOne {
    public static void main(String args[]){
        SpeakCat cat = new SpeakCat();
        SpeeakElephant elephant = new SpeeakElephant();
        cat.start();
        elephant.start();
        for(int i=1;i<=20;i++){
            System.out.println("主人"+i);
        }
    }
}
class SpeeakElephant extends Thread{
    public void run(){
        for(int i=1;i<=20;i++){
            System.out.println("大象"+i);
        }
    }
}

class SpeakCat extends Thread{
    public void run(){
        for(int i=1;i<=20;i++){
            System.out.println("猫咪"+i);
        }
    }
}