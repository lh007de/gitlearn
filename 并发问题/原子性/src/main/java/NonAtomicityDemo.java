/**
 * @ClassName: NonAtomicityDemo
 * @Description: TODO
 * @author: LH
 * @Date: 2020/5/11 16:37
 * @Version: 1.0
 **/
public class NonAtomicityDemo {
    public static void main(String[] args) {
        int i = 10;

        while (i-- > 0) {
            new Thread(new Runnable() {
                public void run() {
                    UnSafeCounter.addCount();
                }
            }).start();
        }
    }
}
