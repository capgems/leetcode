package JavaPractice;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {

    private AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {

        AtomicIntegerExample atomicIntegerExample = new AtomicIntegerExample();
        Thread t1 = new Thread(atomicIntegerExample::increment);
        Thread t2 = new Thread(atomicIntegerExample::increment);

        t1.start();
        t2.start();

        try {
            t2.join();
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Count: " + atomicIntegerExample.counter);
    }

    public void increment() {
        for (int i = 0; i < 100000; i++) {
            counter.getAndIncrement();
        }
    }
}
