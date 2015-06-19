/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certfication.genericsAndCollections;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author f.bertolino
 */
public class LinkedCollections {

    public static void main(String[] args) {

        //////////////// LINKEDLIST
        /* Linked List Declaration */
        LinkedList<String> linkedlist = new LinkedList<>();

        /*add(String Element) is used for adding 
         * the elements to the linked list*/
        linkedlist.add("Item1");
        linkedlist.add("Item5");
        linkedlist.add("Item3");
        linkedlist.add("Item6");
        linkedlist.add("Item2");

        /*Display Linked List Content*/
        System.out.println("Linked List Content: " + linkedlist);

        /*Add First and Last Element*/
        linkedlist.addFirst("First Item");
        linkedlist.addLast("Last Item");
        System.out.println("LinkedList Content after addition: " + linkedlist);

        /*This is how to get and set Values*/
        Object firstvar = linkedlist.get(0);
        System.out.println("First element: " + firstvar);
        linkedlist.set(0, "Changed first item");
        Object firstvar2 = linkedlist.get(0);
        System.out.println("First element after update by set method: " + firstvar2);

        /*Remove first and last element*/
        linkedlist.removeFirst();
        linkedlist.removeLast();
        System.out.println("LinkedList after deletion of first and last element: " + linkedlist);

        /* Add to a Position and remove from a position*/
        linkedlist.add(0, "Newly added item");
        linkedlist.remove(2);
        System.out.println("Final Content: " + linkedlist);
        System.out.println("");

        //////////////// LINKEDHASHSET
        // create a hash set
        LinkedHashSet<String> hs = new LinkedHashSet();
        // add elements to the hash set
        hs.add("B");
        hs.add("A");
        hs.add("D");
        hs.add("E");
        hs.add("C");
        hs.add("F");
        System.out.println(hs);
        Iterator<String> iterator = hs.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("");

        //////////////// LINKEDHASHMAP
        // Create a hash map
        LinkedHashMap<String, Double> lhm = new LinkedHashMap();
        // Put elements to the map
        lhm.put("Zara", 3434.34);
        lhm.put("Mahnaz", 123.22);
        lhm.put("Ayan", 1378.00);
        lhm.put("Daisy", 99.22);
        lhm.put("Qadir", -19.08);

        // Get a set of the entries
        Set set = lhm.entrySet();
        // Get an iterator
        Iterator i = set.iterator();
        // Display elements
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }
        System.out.println();
        // Deposit 1000 into Zara's account
        double balance = lhm.get("Zara");
        lhm.put("Zara", balance + 1000);
        System.out.println("Zara's new balance: "
                + lhm.get("Zara"));
    }
}
