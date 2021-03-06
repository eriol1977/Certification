/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certfication.concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 *
 * @author f.bertolino
 */
public class FindMaxPositionRecursiveTask extends RecursiveTask<Integer> {

    private static final int THRESHOLD = 10000;
    private final int[] data;
    private final int start;
    private final int end;

    public FindMaxPositionRecursiveTask(int[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() { // return type matches the <generic> type
        if (end - start <= THRESHOLD) { // is it a manageable amount of work?
            int position = 0; // if all values are equal, return position 0
            for (int i = start; i < end; i++) {
                if (data[i] > data[position]) {
                    position = i;
                }
            }
            return position;
        } else { // task too big, split it
            int halfWay = ((end - start) / 2) + start;
            FindMaxPositionRecursiveTask t1
                    = new FindMaxPositionRecursiveTask(data, start, halfWay);
            t1.fork(); // queue left half of task
            FindMaxPositionRecursiveTask t2
                    = new FindMaxPositionRecursiveTask(data, halfWay, end);
            int position2 = t2.compute(); // work on right half of task
            int position1 = t1.join(); // wait for queued task to be complete
            // out of the position in two subsection which is greater?
            if (data[position1] > data[position2]) {
                return position1;
            } else if (data[position1] < data[position2]) {
                return position2;
            } else {
                return position1 < position2 ? position1 : position2;
            }
        }
    }

    public static void main(String[] args) {
        int[] data = new int[100_000];
        ForkJoinPool fjPool = new ForkJoinPool();
        RandomInitRecursiveAction action
                = new RandomInitRecursiveAction(data, 0, data.length);
        fjPool.invoke(action);

        FindMaxPositionRecursiveTask task
                = new FindMaxPositionRecursiveTask(data, 0, data.length);
        Integer position = fjPool.invoke(task);
        System.out.println("Position: " + position + ", value: "
                + data[position]);
    }
}
