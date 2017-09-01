package chapter03;

import java.util.concurrent.locks.ReentrantLock;

/***
 * 注意：Lock和synchronized机制的同步不同。
 * Lock锁后，异常出现时候不会自动释放锁。
 */
class ReentrantLockExample {
    int           a    = 0;
    ReentrantLock lock = new ReentrantLock();

    public void writer() {
        lock.lock(); //获取锁
        try {
            a++;
        } finally {
            lock.unlock(); //释放锁
        }
    }

    public void reader() {
        lock.lock(); //获取锁
        try {
            int i = a;
            //……
        } finally {
            lock.unlock(); //释放锁
        }
    }
}
