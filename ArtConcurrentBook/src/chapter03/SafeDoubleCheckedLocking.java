package chapter03;

public class SafeDoubleCheckedLocking {
    private volatile static Instance instance;

    /***
     * Ϊ��Ч�ʸ��ߣ�����Ҫÿ�ζ��������
     * ���Լ�һ��null�жϣ����Ϊnull�Ž���ͬ����
     * ����ô������һ����������ǣ���Ϊnull�������null�������ʱ��
     * ���磬�߳�Aʵ����instance���п���instance�Ȳ�Ϊnull���ٱ���ʼ����
     * ���������߳��ж�instance��Ϊnullֱ�ӷ��أ���ȴ�õ�����һ��δ��ʼ����ɵĶ���
     * 
     * ������Ϊ�ɼ��Ե�ԭ�򡣴˴������ʽ��instance����ʹ��volatile���Ρ�
     */
    public static Instance getInstance() {
        if (instance == null) {
            synchronized (SafeDoubleCheckedLocking.class) {
                if (instance == null)
                    instance = new Instance();//instanceΪvolatile������û������
            }
        }
        return instance;
    }

    static class Instance {
    }
}
