package chapter03;

public class SafeLazyInitialization {
    private static Instance instance;

    /***
     * 首先对比UnsafeLazyInitialization，这个加了同步，所以实现安全单例的实现。
     * 
     * 这个实现要与SafeDoubleCheckedLocking对比。
     * 因为本实现中整个方法被同步，所以不需要考虑多处理器缓存问题（可见性问题）。
     * 本身synchronized就保证了可见性。
     */
    public synchronized static Instance getInstance() {
        if (instance == null)
            instance = new Instance();
        return instance;
    }

    static class Instance {
    }
}