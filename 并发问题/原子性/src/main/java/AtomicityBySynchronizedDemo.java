/**
 * @ClassName: AtomicityBySynchronizedDemo
 * @Description: TODO
 * @author: LH
 * @Date: 2020/5/11 16:47
 * @Version: 1.0
 **/
public class AtomicityBySynchronizedDemo {
    public static void main(String[] args) {
        int i = 10;
        while (i-- > 0) {
            new Thread(() -> SafeCounter.addCount()).start();
        }
    }
}
