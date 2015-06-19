/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certfication.genericsAndCollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author f.bertolino
 */
public class BinarySearch {

    public static void main(String[] args) {
        ////////////////// ARRAYS
        String[] sa = {"one", "two", "three", "four"};
        Arrays.sort(sa); // #1
        for (String s : sa) {
            System.out.print(s + " ");
        }
        System.out.println("\none = " + Arrays.binarySearch(sa, "one")); // #2
        System.out.println("now reverse sort");
        ReSortComparator rs = new ReSortComparator(); // #3
        Arrays.sort(sa, rs);
        for (String s : sa) {
            System.out.print(s + " ");
        }
        System.out.println("\none = " + Arrays.binarySearch(sa, "one")); // #4
        System.out.println("one = " + Arrays.binarySearch(sa, "one", rs)); // #5
        System.out.println("");
        
        ////////////////// COLLECTIONS
        List<String> lista = new ArrayList<>();
        lista.add("one");
        lista.add("two");
        lista.add("three");
        lista.add("four");
        Collections.sort(lista);
        for (String s : lista) {
            System.out.print(s + " ");
        }
        System.out.println("\none = " + Collections.binarySearch(lista, "one"));
        System.out.println("now reverse sort");
        Collections.sort(lista,rs);
        for (String s : lista) {
            System.out.print(s + " ");
        }
        System.out.println("\none = " + Collections.binarySearch(lista, "one"));
        System.out.println("one = " + Collections.binarySearch(lista, "one",rs));
        System.out.println("");
    }

    static class ReSortComparator
            implements Comparator<String> { // #6

        @Override
        public int compare(String a, String b) {
            return b.compareTo(a); // #7
        }
    }
}
