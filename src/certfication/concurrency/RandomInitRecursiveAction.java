/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certfication.concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author f.bertolino
 */
public class RandomInitRecursiveAction extends RecursiveAction {

    private static final int THRESHOLD = 10000;
    private final int[] data;
    private final int start;
    private final int end;

    public RandomInitRecursiveAction(int[] data, int start, int end) {
        this.data = data;
        this.start = start; // where does our section begin at?
        this.end = end; // how large is this section?
    }

    @Override
    protected void compute() {
        if (end - start <= THRESHOLD) { // is it a manageable amount of work? do the task
            for (int i = start; i < end; i++) {
                data[i] = ThreadLocalRandom.current().nextInt();
                System.out.printf("data[%d] = %d\n", i, data[i]);
            }
        } else { // task too big, split it
            int halfWay = ((end - start) / 2) + start;
            RandomInitRecursiveAction a1 = new RandomInitRecursiveAction(data, start, halfWay);
            a1.fork(); // queue left half of task
            RandomInitRecursiveAction a2
                    = new RandomInitRecursiveAction(data, halfWay, end);
            a2.compute(); // work on right half of task
            a1.join(); // wait for queued task to be complete
        }
    }

    public static void main(String[] args) {
        int[] data = new int[1_000_000];
        ForkJoinPool fjPool = new ForkJoinPool();
        RandomInitRecursiveAction action
                = new RandomInitRecursiveAction(data, 0, data.length);
        fjPool.invoke(action);
//        for (int i = 0; i < data.length; i++) {
//            data[i] = ThreadLocalRandom.current().nextInt();
//            System.out.printf("data[%d] = %d\n", i, data[i]);
//        }
    }
}
