/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certfication.genericsAndCollections;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @author f.bertolino
 * 
 * funziona in modo molto simile con TreeMap
 */
public class BackedCollections {

    public static void main(String[] args) {
        TreeSet<Integer> times = new TreeSet<>();
        times.add(1205); // add some departure times
        times.add(1505);
        times.add(1545);
        times.add(1600);
        times.add(1830);
        times.add(2000);
        times.add(2010);
        times.add(2100);

        /////////////////// HEADSET
        SortedSet<Integer> headSet = times.headSet(1600);
        System.out.println("TreeSet: " + times);
        System.out.println("HeadSet (fino a 1600, escluso): " + headSet);
        System.out.println("Aggiungo 1555 nel TreeSet");
        times.add(1555);
        System.out.println("TreeSet: " + times);
        System.out.println("HeadSet (fino a 1600, escluso): " + headSet);
        System.out.println("Aggiungo 1300 nell'HeadSet");
        headSet.add(1300);
        System.out.println("TreeSet: " + times);
        System.out.println("HeadSet (fino a 1600, escluso): " + headSet);
        System.out.println("Rimuovo 1555 dal TreeSet");
        times.remove(1555);
        System.out.println("TreeSet: " + times);
        System.out.println("HeadSet (fino a 1600, escluso): " + headSet);
        System.out.println("Rimuovo 1300 dall'HeadSet");
        headSet.remove(1300);
        System.out.println("TreeSet: " + times);
        System.out.println("HeadSet (fino a 1600, escluso): " + headSet);

        /////////////////// TAILSET
        SortedSet<Integer> tailSet = times.tailSet(1600);
        System.out.println("TreeSet: " + times);
        System.out.println("TailSet (dopo 1600, incluso): " + tailSet);
        System.out.println("Aggiungo 1700 nel TreeSet");
        times.add(1700);
        System.out.println("TreeSet: " + times);
        System.out.println("TailSet (dopo 1600, incluso): " + tailSet);
        System.out.println("Rimuovo 1700 dal TreeSet");
        times.remove(1700);
        System.out.println("TreeSet: " + times);
        System.out.println("TailSet (dopo 1600, incluso): " + tailSet);

        /////////////////// SUBSET
        SortedSet<Integer> subSet = times.subSet(1500, 2000);
        System.out.println("TreeSet: " + times);
        System.out.println("SubSet (tra 1500 e 2000): " + subSet);
        try {
            subSet.add(2300);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
