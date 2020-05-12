/**
 * @ClassName: SafeCounter
 * @Description: TODO
 * @author: LH
 * @Date: 2020/5/11 16:49
 * @Version: 1.0
 **/
public class SafeCounter {
    private static int counter = 0;

    //synchronized关键字修饰
    public static synchronized void addCount() {
        counter++;
        System.out.println(counter);
    }
}
