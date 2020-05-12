/**
 * @ClassName: createThread01
 * @Description: TODO
 * @author: LH
 * @Date: 2020/5/11 17:25
 * @Version: 1.0
 **/
public class createThread01 {
    public static void main(String[] args) {
        new MyThread().start();
        new MyThread().start();
        new MyThread().start();


    }
}
class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("hello " + Thread.currentThread().getName() + ":"+Thread.currentThread().getId());
    }
}
