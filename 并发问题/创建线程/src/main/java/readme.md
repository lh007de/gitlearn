# 创建线程方法
## 1.直接继承 Thread 类
基础Thread 类，复写run方法，通过start方法调用如：createThread01
    
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
    // output
    hello Thread-0:12
    hello Thread-1:13
    hello Thread-2:14
    
## 2.实现 Runable 接口
    
    public static void main(String[] args) {
            MyRunable myRunable = new MyRunable();
            Thread t1 = new Thread(myRunable);
            Thread t2 = new Thread(myRunable);
            Thread t3 = new Thread(myRunable);
    
            t1.start();
            t2.start();
            t3.start();
    
        }
    }
    
    class MyRunable implements Runnable{
        public void run() {
            System.out.println("hello " + Thread.currentThread().getName() + ":"+Thread.currentThread().getId());
    
        }
    }
    // 也可以直接通过匿名内部类实现
    new Thread(()->System.out.println("hello,this is " + Thread.currentThread().getName())).start();
    
 ## 实现Callable 接口
 步骤：
 1. 创建 Callable 接口的实现类，并实现 call()方法
 2. 创建 Callable 实现类的实例，并将其做为构造参数传入到 FutureTask 类实例中，该 FutureTask 对象封装了 Callback 对象的 call()方法的返回值
 3. 将 FutureTask 对象作为 Thread 实例的构造参数（target）传入到 Thread 实例中，创建并启动新线程
 4. 调用 FutureTask 对象的 get()方法来获得子线程执行结束后的返回值
 参考createThread03
 
    也可以使用匿名内部类实现
    
        public static void main(String[] args) throws ExecutionException, InterruptedException {
            FutureTask<String> task = new FutureTask<>(() -> Thread.currentThread().getName());
            new Thread(task).start();
            System.out.println(task.get());
        }

 
