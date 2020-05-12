/**
 * @ClassName: UnSafeCounter
 * @Description: TODO
 * @author: LH
 * @Date: 2020/5/11 16:38
 * @Version: 1.0
 **/
public class UnSafeCounter {
    private static int counter = 0;

    public static void addCount() {
        counter++;
        System.out.println(counter);
    }

}
