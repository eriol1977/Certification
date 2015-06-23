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
public class Sleep {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int remainder;
                for(int i=1; i <=100; i++) {
                    remainder = i%10;
                    if(remainder == 0) {
                        System.out.println(i);
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Sleep.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }

}
