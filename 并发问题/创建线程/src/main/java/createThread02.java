/**
 * @ClassName: createThread02
 * @Description: TODO
 * @author: LH
 * @Date: 2020/5/11 17:33
 * @Version: 1.0
 **/
public class createThread02 {
    public static void main(String[] args) {
        MyRunable myRunable = new MyRunable();
        Thread t1 = new Thread(myRunable);
        Thread t2 = new Thread(myRunable);
        Thread t3 = new Thread(myRunable);

        t1.start();
        t2.start();
        t3.start();
//        new Thread(()->System.out.println("hello,this is " + Thread.currentThread().getName())).start();

    }
}

class MyRunable implements Runnable{
    @Override
    public void run() {
        System.out.println("hello " + Thread.currentThread().getName() + ":"+Thread.currentThread().getId());

    }
}
