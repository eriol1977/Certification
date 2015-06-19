/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certfication.genericsAndCollections;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author f.bertolino
 */
public class ListToArray {
    public static void main(String[] args) {
        List<String> prova = new ArrayList<>();
        prova.add("uno");
        prova.add("due");
        prova.add("tre");
        String[] array1 = new String[3];
        String[] altro = prova.toArray(array1);
        System.out.print("Array1: ");
        for(String s: array1)
            System.out.print(s + " ");
        System.out.println("");
        System.out.print("Array2: ");
        for(String s: altro)
            System.out.print(s + " ");
        
        System.out.println("");
        System.out.println("Aggiungo due numeri oltre le dimensioni di Array1");
        
        prova.add("quattro");
        prova.add("cinque");
        altro = prova.toArray(array1);
        System.out.print("Array1: ");
        for(String s: array1)
            System.out.print(s + " ");
        System.out.println("");
        System.out.print("Array2: ");
        for(String s: altro)
            System.out.print(s + " ");
        
         System.out.println("");
    }
}
