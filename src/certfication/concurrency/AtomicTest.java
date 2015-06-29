/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certfication.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author f.bertolino
 */
public class AtomicTest {

    public static void main(String[] args) throws InterruptedException {
        Counter wc = new WrongCounter();
        IncrementerThread it1 = new IncrementerThread(wc);
        IncrementerThread it2 = new IncrementerThread(wc);
        it1.start(); // thread 1 increments the count by 10000
        it2.start(); // thread 2 increments the count by 10000
        it1.join(); // wait for thread 1 to finish
        it2.join(); // wait for thread 2 to finish
        System.out.println("Probably wrong value: " + wc.getValue());

        Counter c = new AtomicCounter(); // the shared object
        IncrementerThread it3 = new IncrementerThread(c);
        IncrementerThread it4 = new IncrementerThread(c);
        it3.start(); // thread 1 increments the count by 10000
        it4.start(); // thread 2 increments the count by 10000
        it3.join(); // wait for thread 1 to finish
        it4.join(); // wait for thread 2 to finish
        System.out.println("Right value: " + c.getValue());
    }

    interface Counter {

        void increment();

        int getValue();
    }

    static class WrongCounter implements Counter {

        private int count;

        @Override
        public void increment() {
            count++; // it's a trap! a single "line" is not atomic
        }

        @Override
        public int getValue() {
            return count;
        }
    }

    static class AtomicCounter implements Counter {

        private final AtomicInteger count = new AtomicInteger();

        @Override
        public void increment() {
            count.getAndIncrement(); // atomic operation
        }

        @Override
        public int getValue() {
            return count.intValue();
        }
    }

    static class IncrementerThread extends Thread {

        private final Counter counter; // all instances are passed the same counter

        public IncrementerThread(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            // "i" is local and thread-safe
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        }
    }
}
