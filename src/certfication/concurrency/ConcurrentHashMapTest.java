/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certfication.concurrency;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author f.bertolino
 */
public class ConcurrentHashMapTest {

    public static void main(String[] args) throws InterruptedException {
        final ConcurrentMap<Integer, String> map = new ConcurrentHashMap<>();
        final Thread t1 = new Thread(new Putter(map),"PIPPO");
        final Thread t2 = new Thread(new Putter(map),"PLUTO");
        final Thread t3 = new Thread(new Putter(map),"PAPERINO");
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        for (int i = 1; i <= 100; i++) {
            System.out.printf("map[%d] = %s\n",i,map.get(i));
        }
    }

    static class Putter implements Runnable {

        final ConcurrentMap<Integer, String> map;

        public Putter(ConcurrentMap<Integer, String> map) {
            this.map = map;
        }

        @Override
        public void run() {
            final String name = Thread.currentThread().getName();
            for (int i = 1; i <= 100; i++) {
                this.map.putIfAbsent(i, "PUT BY " + name.toUpperCase());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ConcurrentHashMapTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
}
