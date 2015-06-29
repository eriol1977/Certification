/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certfication.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author f.bertolino
 */
public class BlockingQueueTest {

    public static void main(String[] args) {
        final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);
        final Thread producer = new Thread(new Producer(queue), "Producer");
        final Thread consumer = new Thread(new Consumer(queue), "Consumer");
        producer.start();
        consumer.start();
    }

    static class Producer implements Runnable {

        private final BlockingQueue<Integer> queue;

        public Producer(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            final String name = Thread.currentThread().getName();
            for (int i = 1; i <= 10; i++) {
                try {
                    System.out.printf("%s waiting to put %d\n", name, i);
                    queue.put(i);
                    System.out.printf("%s has put %d\n", name, i);
                    System.out.printf("%s sleeping...\n", name);
                    Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
                } catch (InterruptedException ex) {
                    Logger.getLogger(BlockingQueueTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    static class Consumer implements Runnable {

        private final BlockingQueue<Integer> queue;

        public Consumer(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            Integer taken;
            final String name = Thread.currentThread().getName();
            for (int i = 1; i <= 10; i++) {
                try {
                    System.out.printf("%s waiting to take %d\n", name, i);
                    taken = queue.take();
                    System.out.printf("%s has taken %d\n", name, taken);
                    System.out.printf("%s sleeping...\n", name);
                    Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
                } catch (InterruptedException ex) {
                    Logger.getLogger(BlockingQueueTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

}
