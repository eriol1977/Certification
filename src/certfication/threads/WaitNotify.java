/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certfication.threads;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author f.bertolino
 */
public class WaitNotify {

    public static void main(String[] args) {
        ThreadB b = new ThreadB();
        b.start();
        synchronized (b) {
            try {
                System.out.println("Waiting for b to complete...");
                b.wait();
            } catch (InterruptedException e) {
            }
            System.out.println("Total is: " + b.total);
        }
    }

    static class ThreadB extends Thread {

        int total;

        @Override
        public void run() {
            synchronized (this) {
                for (int i = 0; i < 100; i++) {
                    total += i;
                    System.out.println("Partial sum: " + total);
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(WaitNotify.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                notify();
            }
        }
    }
}
