/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certfication;

import java.util.Scanner;

/**
 * Asks for an input String, then finds every occurrence of PATTERN
 */
public class ScanningInput {

    private final static String PATTERN = "\\d\\d";
    
    public static void main(String[] args) {
        System.out.print("input: ");
        System.out.flush();
        try {
            Scanner s = new Scanner(System.in);
            String token;
            do {
                token = s.findInLine(PATTERN);
                System.out.println("found " + token);
            } while (token != null);
        } catch (Exception e) {
            System.out.println("scan exc");
        }
    }
}
