/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certfication.genericsAndCollections;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author f.bertolino
 */
public class ArrayAsList {

    public static void main(String[] args) {
        String[] sa = {"one", "two", "three", "four"};
        List<String> sList = Arrays.asList(sa); // make a List
         for (String s : sList) {
            System.out.print(s + " ");
        }
        System.out.println("");
        System.out.println("size " + sList.size());
        System.out.println("idx2 " + sList.get(2));
        sList.set(3, "six"); // change List and affect array
        for (String s : sa) {
            System.out.print(s + " ");
        }
        System.out.println("");
        sa[1] = "five"; // change array and affect list
        for (String s : sList) {
            System.out.print(s + " ");
        }
        System.out.println("");
    }
}
