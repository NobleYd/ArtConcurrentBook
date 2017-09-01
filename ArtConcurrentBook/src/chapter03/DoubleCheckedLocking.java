package chapter03;

public class DoubleCheckedLocking { //1
    private static Instance instance; //2

    //����Ч�ʿ��ǣ�����Ҫ�ܼ�����ͨ���ж��Ƿ�null�����Ƿ������ʼ����
    //������ӵ�����������Ա�SafeDoubleCheckedLocking
    public static Instance getInstance() { //3
        if (instance == null) { //4:��һ�μ��
            synchronized (DoubleCheckedLocking.class) { //5:����
                if (instance == null) //6:�ڶ��μ��
                    instance = new Instance(); //7:����ĸ�Դ��������
            } //8
        } //9
        return instance; //10
    } //11

    static class Instance {
    }
}
