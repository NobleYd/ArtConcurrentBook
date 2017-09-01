package chapter03;

public class DoubleCheckedLocking { //1
    private static Instance instance; //2

    //出于效率考虑，不需要总加锁，通过判断是否null决定是否加锁初始化。
    //这个例子的问题所在请对比SafeDoubleCheckedLocking
    public static Instance getInstance() { //3
        if (instance == null) { //4:第一次检查
            synchronized (DoubleCheckedLocking.class) { //5:加锁
                if (instance == null) //6:第二次检查
                    instance = new Instance(); //7:问题的根源出在这里
            } //8
        } //9
        return instance; //10
    } //11

    static class Instance {
    }
}
