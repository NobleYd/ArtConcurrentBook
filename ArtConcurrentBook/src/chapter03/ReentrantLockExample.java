package chapter03;

import java.util.concurrent.locks.ReentrantLock;

/***
 * ע�⣺Lock��synchronized���Ƶ�ͬ����ͬ��
 * Lock�����쳣����ʱ�򲻻��Զ��ͷ�����
 */
class ReentrantLockExample {
    int           a    = 0;
    ReentrantLock lock = new ReentrantLock();

    public void writer() {
        lock.lock(); //��ȡ��
        try {
            a++;
        } finally {
            lock.unlock(); //�ͷ���
        }
    }

    public void reader() {
        lock.lock(); //��ȡ��
        try {
            int i = a;
            //����
        } finally {
            lock.unlock(); //�ͷ���
        }
    }
}
