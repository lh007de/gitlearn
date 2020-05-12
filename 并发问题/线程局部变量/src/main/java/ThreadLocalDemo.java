/**
 * @ClassName: ThreadLocalDemo
 * @Description: TODO
 * @author: LH
 * @Date: 2020/5/12 9:12
 * @Version: 1.0
 **/
public class ThreadLocalDemo {
    // 通过默认构造函数，创建线程局部变量
//    public static ThreadLocal<Integer> threadLocalData = new ThreadLocal<Integer>();

    // 带初始值的创建线程局部变量
    public static ThreadLocal<Integer> threadLocalData1 = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 1;
        }
    };
    public static void main(String[] args) {
        //输出为Null
//        System.out.println(threadLocalData.get());

        // 输出为1
        System.out.println(threadLocalData1.get());
    }
}
