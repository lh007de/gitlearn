import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: VisibilityByAtomicDemo
 * @Description: TODO
 * @author: LH
 * @Date: 2020/5/11 17:19
 * @Version: 1.0
 **/
public class VisibilityByAtomicDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("\nVisibilityByAtomicDemo");
        new ReadThread().start();
        Thread.sleep(1000);
        new WriteThread().start();
    }

    static class ShareData {
        public static AtomicInteger flag = new AtomicInteger(-1);

    }

    static class ReadThread extends Thread {

        @Override
        public void run() {
            System.out.println("read-thread start");
            while (true) {
                if (ShareData.flag.get() == 1) {
                    System.out.println("read-thread end");
                    break;
                }
            }
        }
    }

    static class WriteThread extends Thread {
        @Override
        public void run() {
            ShareData.flag.set(1);
            System.out.println("write-thread:flag=" + ShareData.flag);
        }
    }
}
