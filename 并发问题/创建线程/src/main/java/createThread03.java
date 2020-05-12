import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ClassName: createThread03
 * @Description: TODO
 * @author: LH
 * @Date: 2020/5/12 8:53
 * @Version: 1.0
 **/
public class createThread03  {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //将Callable接口的实现实例作为构造参数传递给FutureTask实例
        FutureTask<String> futureTask = new FutureTask<>(new MyCallable1());
        //将futureTask作为构造参数传递给Thread实例,并启动这个线程
        new Thread(futureTask).start();
        //在主线程中获取futureTask实例的执行结果
        String result = futureTask.get();
        System.out.println(result);//打印线程执行结果--线程的名称Thread0
    }

}

//实现Callable接口，返回值为String类型
class MyCallable1 implements Callable<String> {

    //将线程的名字做为返回值
    @Override
    public String call() throws Exception {
        String name = Thread.currentThread().getName();
        Thread.sleep(1000);
        return name;
    }
}
