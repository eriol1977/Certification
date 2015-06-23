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
public class Join {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread started");
        final Thread another = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Another thread started");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Join.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Another thread finished");
            }
        });
        another.start();
        System.out.println("Main thread waiting for another to finish");
        another.join();
        System.out.println("Main thread finished waiting");
        System.out.println("Main thread finished");
    }
}
