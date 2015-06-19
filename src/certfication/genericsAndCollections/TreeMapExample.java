/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certfication.genericsAndCollections;

import java.util.TreeMap;

/**
 *
 * @author f.bertolino
 */
public class TreeMapExample {

    public static void main(String[] args) {
        final TreeMap<Integer, String> times = new TreeMap<>();
        times.put(1205, "12:05");
        times.put(1505, "15:05");
        times.put(1545, "15:45");
        times.put(1600, "16:00");
        times.put(1830, "18:30");
        times.put(2000, "20:00");
        times.put(2010, "20:10");
        times.put(2100, "21:00");
        
        System.out.println("J6 - last before 4pm is: " + times.lowerKey(1600) + " -> " + times.lowerEntry(1600));
        System.out.println("J6 - first after 8pm is: " + times.higherKey(2000));
        System.out.println("J6 - last before/at 4pm is: " + times.floorKey(1600));
        System.out.println("J6 - first after/at 8pm is: " + times.ceilingKey(2000));
        
        System.out.println("Original tree: " + times);
        System.out.println(times.pollFirstEntry());
        System.out.println(times.pollFirstEntry());
        System.out.println("After polling firsts: " + times);
        System.out.println(times.pollLastEntry());
        System.out.println(times.pollLastEntry());
        System.out.println("After polling lasts: " + times);
        
        System.out.println("In ordine discendente: " + times.descendingMap());
    }
}
