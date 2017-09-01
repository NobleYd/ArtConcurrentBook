package chapter03;

public class SafeDoubleCheckedLocking {
    private volatile static Instance instance;

    /***
     * 为了效率更高，不需要每次都获得锁。
     * 所以加一个null判断，如果为null才进行同步。
     * 但这么做导致一个新问题就是，不为null的情况和null情况并发时。
     * 比如，线程A实例化instance，有可能instance先不为null，再被初始化。
     * 导致其他线程判断instance不为null直接返回，但却拿到的是一个未初始化完成的对象。
     * 
     * 这是因为可见性的原因。此处解决方式是instance变量使用volatile修饰。
     */
    public static Instance getInstance() {
        if (instance == null) {
            synchronized (SafeDoubleCheckedLocking.class) {
                if (instance == null)
                    instance = new Instance();//instance为volatile，现在没问题了
            }
        }
        return instance;
    }

    static class Instance {
    }
}
