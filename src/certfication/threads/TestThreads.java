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
public class TestThreads {

    public static void main(String[] args) {
        Thread a = new Thread(new MyRunnable(), "A");
        Thread b = new Thread(new MyRunnable(), "B");
        Thread c = new Thread(new MyRunnable(), "C");
        System.out.println("A state: " + a.getState());
        System.out.println("B state: " + b.getState());
        System.out.println("C state: " + c.getState());
        a.start();
        b.start();
        c.start();
        //a.run(); Legal, but does not start a new thread!
        System.out.println("A state: " + a.getState());
        System.out.println("B state: " + b.getState());
        System.out.println("C state: " + c.getState());

        try {
            a.start();
        } catch (IllegalThreadStateException e) {
            System.out.println("You cant't start the same thread twice! " + e.toString());
        }
    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            try {
                final String name = Thread.currentThread().getName();
                final long id = Thread.currentThread().getId();
                System.out.println(name + "(ID: " + id + ") has started! State: " + Thread.currentThread().getState());
                Thread.sleep((long) (Math.random() * 2000));
                System.out.println(name + " is running! State: " + Thread.currentThread().getState());
                Thread.sleep((long) (Math.random() * 2000));
                System.out.println(name + " has finished! State: " + Thread.currentThread().getState());
            } catch (InterruptedException ex) {
                Logger.getLogger(TestThreads.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
