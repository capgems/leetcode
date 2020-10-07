package JavaPractice;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LiveLockExample {

    private Lock lock1 = new ReentrantLock(true);
    private Lock lock2 = new ReentrantLock(true);

    public static void main(String[] args) {

        LiveLockExample liveLockExample = new LiveLockExample();
        new Thread(liveLockExample::worker1, "worker1").start();
        new Thread(liveLockExample::worker2, "worker2").start();
    }

    public void worker1() {

        while (true) {
            try {
                lock1.tryLock(50, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("worker 1 acquires the lock 1");
            System.out.println("worker 1 tries to  get the lock 2");

            if (lock2.tryLock()) {
                System.out.println("worker 1 acquires the lock 2");
                lock2.unlock();
            } else {
                System.out.println("worker 1 cannot get the lock 2");
                continue;
            }
            break;
        }

        lock1.unlock();
        lock2.unlock();
    }

    public void worker2() {
        while (true) {
            try {
                lock2.tryLock(50, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("worker 2 acquires the lock 2");
            System.out.println("worker 2 tries to  get the lock 1");

            if (lock1.tryLock()) {
                System.out.println("worker 2 acquires the lock 1");
                lock1.unlock();
            } else {
                System.out.println("worker 2 cannot get the lock 1");
                continue;
            }
            break;
        }

        lock1.unlock();
        lock2.unlock();
    }

}
