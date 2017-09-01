package chapter03;

public class UnsafeLazyInitialization {
    private static Instance instance;

    //B线程执行初始化过程中A线程还看不到instance的变化，或者A在此前已经执行了判断，刚刚进入判断内部。
    public static Instance getInstance() {
        if (instance == null) //1：A线程执行
            instance = new Instance(); //2：B线程执行
        return instance;
    }

    static class Instance {
    }
}
