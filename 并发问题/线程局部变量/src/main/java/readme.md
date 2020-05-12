# ThreadLocal

在线程安全中，我们常使用volatile和synchronized来保证访问临界资源的安全性和可见性。
可见性就是，一个线程对临界资源改变后，另一个线程能看到改变后的资源。

现在的情况是我们每个线程都需要临界资源的一个副本，每个线程对该副本单独使用，对其他线程不可见。

线程局部变量就是为每一个使用该变量的线程都提供一个变量值的副本，该副本是线程私有的，不同的线程持有不同的副本，每个线程都可以独立的改变这个副本并且不会和其他的线程起冲突
保证了线程之间的隔离性

    get()方法用于获取当前线程的副本变量值
    public T get()
    
    set()方法用于写入当前线程的副本变量值
    public void set(T value)
    
    remove()方法移除当前前程的副本变量值。每次 remove()之后都会对副本变量应用一次 initialValue(),恢复副本的初始值。所以 remove()之后再 get()得到的是初始值。
    public void remove()
    
    
    // 一个示例
    public static ThreadLocal<Integer> threadLocalData = ThreadLocal.withInitial(() -> 1);
    
    public static void main(String[] args) {
    
         //先使用remove()移除值，再获取值
         new Thread(() -> {
             threadLocalData.remove();
             System.out.println("remove()&get()" + threadLocalData.get());//输出remove()&get()1
         }).start();
         //直接使用get()获取值
         new Thread(() -> System.out.println("get()" + threadLocalData.get())).start();//输出get()1
         //先使用set()设置值，再获取
         new Thread(() -> {
             threadLocalData.set(2);
             System.out.println("set()&get()" + threadLocalData.get());//输出set()&get()2
         }).start();
     }