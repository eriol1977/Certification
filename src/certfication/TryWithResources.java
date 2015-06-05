/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certfication;

import certfication.util.MyBufferedReader;
import certfication.util.MyFileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author f.bertolino
 */
public class TryWithResources {

    public static void main(String[] args) throws IOException {
        
        
        try (final BufferedReader reader = new MyBufferedReader(new MyFileReader(new File("Test.txt")))) {
            System.out.println(reader.readLine());
        }
    }
    
    
}
