import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: AtomicityByAtomicIntegerDemo
 * @Description: TODO
 * @author: LH
 * @Date: 2020/5/11 16:55
 * @Version: 1.0
 **/

public class AtomicityByAtomicIntegerDemo {
    public static void main(String[] args) throws InterruptedException {
        int i = 10;
        while (i-- > 0) {
            new Thread(() -> SafeCounter.addCount()).start();
        }
        Thread.sleep(3000);//等待子线程执行结束
        System.out.println(SafeCounter.counter);
        //输出10
    }


    static class SafeCounter {
        private static AtomicInteger counter = new AtomicInteger(0);

        public static void addCount() {
            counter.incrementAndGet();//对比count++,counter.incrementAndGet()是原子操作，而count++不是原子操作
        }

    }
}

