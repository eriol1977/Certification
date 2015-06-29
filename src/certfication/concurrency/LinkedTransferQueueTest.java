/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certfication.concurrency;

import java.util.concurrent.LinkedTransferQueue;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import java.util.concurrent.TransferQueue;

/**
 *
 * @author f.bertolino
 */
public class LinkedTransferQueueTest {

    public static void main(String[] args) throws InterruptedException {
        TransferQueue<Integer> tq = new LinkedTransferQueue<>(); // not bounded
        boolean b1 = tq.add(1); // returns true if added or throws IllegalStateException if full
        tq.put(2); // blocks if bounded and full
        boolean b3 = tq.offer(3); // returns true if added or false if bounded and full; recommended over add
        boolean b4 = tq.offer(4, 10, MILLISECONDS); // returns true if added within the given time, false if bound and full
        tq.transfer(5); // blocks until this element is consumed
        boolean b6 = tq.tryTransfer(6); // returns true if consumed by an awaiting thread or returns false without adding if there was no awaiting consumer
        boolean b7 = tq.tryTransfer(7, 10, MILLISECONDS); // will wait the given time for a consumer
        Integer i1 = tq.element(); // gets without removing throws NoSuchElementException if empty
        Integer i2 = tq.peek(); // gets without removing returns null if empty
        Integer i3 = tq.poll(); // removes the head of the queue returns null if empty
        Integer i4 = tq.poll(10, MILLISECONDS); // removes the head of the queue, waits up to the time specified before returning null if empty
        Integer i5 = tq.remove(); // removes the head of the queue, throws NoSuchElementException if empty
        Integer i6 = tq.take(); // removes the head of the queue, blocks until an element is ready
    }
}
