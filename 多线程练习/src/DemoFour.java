/**
 * @Author DaWeiGuo
 * @Date 2020/8/13 19:47
 * @desc: 线程同步 synchronized修饰的方法一个线程在使用的时候其他线程不能使用
 */
public class DemoFour {
    public static void main(String args[]){
        Bank bank = new Bank();
        bank.setMoney(200);
        Thread account = new Thread(bank),
                cashier = new Thread(bank);
        account.setName("会计");
        cashier.setName("出纳");
        account.start();
        cashier.start();
    }
}
class Bank implements Runnable{
    int money = 200;
    public void setMoney(int n){
        this.money = n;
    }
    public void run(){
        if (Thread.currentThread().getName().equals("会计"))
            savaOrtake(300);
        else if (Thread.currentThread().getName().equals("出纳"))
            savaOrtake(150);
    }
    public synchronized void savaOrtake(int amount){
        if(Thread.currentThread().getName().equals("会计")){
            for(int i=1;i<=3;i++){
                money = money + amount/3;
                System.out.println(Thread.currentThread().getName()+"存入"+amount/3);
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }else if(Thread.currentThread().getName().equals("出纳")){
            for(int i=1;i<=3;i++){
                money = money - amount/3;
                System.out.println(Thread.currentThread().getName()+"取出"+amount/3+"账上有"+money+"万，休息一会再取");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}