/**
 * @ClassName: VisibilityByVolatileDemo
 * @Description: TODO
 * @author: LH
 * @Date: 2020/5/11 17:16
 * @Version: 1.0
 **/
public class VisibilityByVolatileDemo {
    public static void main(String[] args) throws InterruptedException {
        new ReadThread().start();
        Thread.sleep(1000);
        new WriteThread().start();
    }

    static class ShareData {
        //使用volatile关键字修饰
        public static volatile int flag = -1;
    }

    static class ReadThread extends Thread {

        @Override
        public void run() {
            System.out.println("read-thread start");
            while (true) {
                if (ShareData.flag == 1) {
                    System.out.println("read-thread end");
                    break;
                }
            }
        }
    }

    static class WriteThread extends Thread {
        @Override
        public void run() {
            ShareData.flag = 1;
            System.out.println("write-thread:flag=" + ShareData.flag);
        }
    }
}
