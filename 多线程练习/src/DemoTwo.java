/**
 * @Author DaWeiGuo
 * @Date 2020/8/13 10:55
 * @desc: 通过实现接口Runnable创建线程
 */
public class DemoTwo {
    public static void main(String args[]){
        House house = new House();
        house.setWater(10);
        Thread dog = new Thread(house);
        Thread cat = new Thread(house);
        dog.start();
        cat.start();
    }
}
class House implements Runnable{
    int waterAmount;
    public void setWater(int w){
        this.waterAmount = w;
    }
    @Override
    public void run() {
        int m = 1;
        while(true){
            if(waterAmount<=0){
                return;
            }
            waterAmount = waterAmount - m;
            System.out.println("剩下"+waterAmount+"克");
            try {
                Thread.sleep(2000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
