package chapter03;

public class SafeLazyInitialization {
    private static Instance instance;

    /***
     * ���ȶԱ�UnsafeLazyInitialization���������ͬ��������ʵ�ְ�ȫ������ʵ�֡�
     * 
     * ���ʵ��Ҫ��SafeDoubleCheckedLocking�Աȡ�
     * ��Ϊ��ʵ��������������ͬ�������Բ���Ҫ���Ƕദ�����������⣨�ɼ������⣩��
     * ����synchronized�ͱ�֤�˿ɼ��ԡ�
     */
    public synchronized static Instance getInstance() {
        if (instance == null)
            instance = new Instance();
        return instance;
    }

    static class Instance {
    }
}