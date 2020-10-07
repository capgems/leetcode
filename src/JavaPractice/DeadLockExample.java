package JavaPractice;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockExample {

    private Lock lock1 = new ReentrantLock(true);
    private Lock lock2 = new ReentrantLock(true);

    public static void main(String[] args) {

        DeadLockExample deadLockExample = new DeadLockExample();
        new Thread(deadLockExample::worker1,"worker1").start();
        new Thread(deadLockExample::worker2,"worker2").start();
    }

    public void worker1() {
        lock1.lock();
        System.out.println("worker 1 acquires the lock 1");

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lock2.lock();
        System.out.println("worker 1 acquires the lock 2..");

        lock1.unlock();
        lock2.unlock();

    }

    public void worker2() {
        lock2.lock();
        System.out.println("worker 2 acquires the lock 2");

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lock1.lock();
        System.out.println("worker 2 acquires the lock 1..");

        lock2.unlock();
        lock1.unlock();
    }
}
