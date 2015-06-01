/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certfication;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author f.bertolino
 */
public class UsingResourceBundles {
    public static void main(String[] args) {
        final ResourceBundle rbEng = ResourceBundle.getBundle("Labels", new Locale("en"));
        System.out.println(rbEng.getString("hello"));
        final ResourceBundle rbFra = ResourceBundle.getBundle("Labels", new Locale("fr"));
        System.out.println(rbFra.getString("hello"));
    }
}
