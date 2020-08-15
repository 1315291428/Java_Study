/**
 * @Author DaWeiGuo
 * @Date 2020/8/14 10:15
 * @desc: 在同步方法中使用wait() notify() notifyall()方法
 */
public class DemoFive {
    public static void main(String args[]) {
        TicketHouse officer = new TicketHouse();
        Thread zhangfei = new Thread(officer);
        Thread likui = new Thread(officer);
        zhangfei.setName("张飞");
        likui.setName("李逵");
        zhangfei.start();
        likui.start();
    }
}

class TicketHouse implements Runnable {
    int fiveAmount = 2,
            tenAmount = 0,
            twentyAmount = 0;

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("张飞")) {
            saleTicket(20);
        } else if (Thread.currentThread().getName().equals("李逵")) {
            saleTicket(5);
        }
    }

    private synchronized void saleTicket(int money) {
        if (money == 5) {
            fiveAmount = fiveAmount + 1;
            System.out.println("给" + Thread.currentThread().getName() + "入场券" + Thread.currentThread().getName() + "的钱正好");
        } else if (money == 20) {
            while (fiveAmount < 3) {
                try {
                    System.out.println("\n" + Thread.currentThread().getName() + "靠边等");
                    wait();
                    System.out.println("\n" + Thread.currentThread().getName() + "继续买票");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            fiveAmount = fiveAmount - 3;
            twentyAmount = twentyAmount + 1;
            System.out.println("给" + Thread.currentThread().getName() + "入场券," + Thread.currentThread().getName() + "给20，找回15");
        }
        notifyAll();
    }
}