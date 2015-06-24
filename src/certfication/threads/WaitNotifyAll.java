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
public class WaitNotifyAll extends Thread {

    Calculator c;

    /**
     *
     * @param calc
     */
    public WaitNotifyAll(Calculator calc) {
        c = calc;
    }

    @Override
    public void run() {
        synchronized (c) {
            try {
                System.out.println("Waiting for calculation...");
                c.wait();
            } catch (InterruptedException e) {
            }
            System.out.println("Total is: " + c.total);
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        new WaitNotifyAll(calculator).start();
        new WaitNotifyAll(calculator).start();
        new WaitNotifyAll(calculator).start();
        new Thread(calculator).start();
    }
}

class Calculator implements Runnable {

    int total;

    public void run() {
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                total += i;
                try {
                    Thread.sleep(20);
                } catch (InterruptedException ex) {
                    Logger.getLogger(WaitNotify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            notifyAll();
        }

    }
}
