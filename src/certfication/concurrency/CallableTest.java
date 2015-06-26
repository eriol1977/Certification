/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certfication.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author f.bertolino
 */
public class CallableTest {

    public static void main(String[] args) {
        Callable<Integer> c1 = new MyCallable("C1");
        Callable<Integer> c2 = new MyCallable("C2");
        ExecutorService ex = Executors.newCachedThreadPool();
        Future<Integer> f1 = ex.submit(c1); // finishes in the future
        Future<Integer> f2 = ex.submit(c2);
        try {
            Integer v1 = f1.get(); // blocks until done
            Integer v2 = f2.get();
            System.out.println("C1 ran:" + v1);
            System.out.println("C1 ran:" + v2);
        } catch (InterruptedException | ExecutionException iex) {
            System.out.println("Failed");
        }
        ex.shutdown();
    }

    static class MyCallable implements Callable<Integer> {

        private final String name;

        public MyCallable(String name) {
            this.name = name;
        }
        
        @Override
        public Integer call() {
            // Obtain a random number from 1 to 10
            int count = ThreadLocalRandom.current().nextInt(10, 21);
            for (int i = 1; i <= count; i++) {
                System.out.println(name + " running..." + i);
            }
            return count;
        }
    }
}
