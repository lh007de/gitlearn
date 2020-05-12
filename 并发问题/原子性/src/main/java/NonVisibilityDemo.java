/**
 * @ClassName: NonVisibilityDemo
 * @Description: TODO
 * @author: LH
 * @Date: 2020/5/11 17:10
 * @Version: 1.0
 **/
public class NonVisibilityDemo {
    public static void main(String[] args) throws InterruptedException {
        new ReadThread().start();
        Thread.sleep(1000);
        new WriteThread().start();
    }
}


class ReadThread extends Thread {

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

class ShareData {
    public static int flag = -1;
}


class WriteThread extends Thread {
    @Override
    public void run() {
        ShareData.flag = 1;
        System.out.println("write-thread:flag=" + ShareData.flag);
    }
}

