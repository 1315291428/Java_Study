/**
 * @Author DaWeiGuo
 * @Date 2020/8/13 11:16
 * @desc: interrupt()打断休眠中的线程
 */
public class DemoThree {
    public static void main(String args[]){
        Road road = new Road();
        Thread police = new Thread(road);
        Thread driver = new Thread(road);
        police.setName("警察");
        driver.setName("司机");
        road.setAttachThread(driver);
        driver.start();
        police.start();
    }
}
class Road implements Runnable{
    Thread attachThread;
    public void setAttachThread(Thread t){
        this.attachThread = t;
    }
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        if(name.equals("司机")){
            try{
                System.out.println("我是"+name+"在马路上开车");
                System.out.println("想在车上睡一个小时再开车");
                Thread.sleep(1000*60*60);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("司机被警察吵醒了");
            }
        }else if(name.equals("警察")){
            for(int i=1;i<=3;i++){
                System.out.println(name+"第"+i+"次"+"喊司机开车！");
                try{
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            attachThread.interrupt();
        }
    }
}