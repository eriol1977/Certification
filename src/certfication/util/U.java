/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certfication.util;

/**
 *
 * @author f.bertolino
 */
public class U {
    
    private final static String sep = "--------------------------------------------------------------------------";
    private final static String end = "##########################################################################";
    
    public static void h(final String header)
    {
        System.out.println(sep);
        System.out.println(header);
        System.out.println(sep);
    }
    
    public static void e()
    {
        System.out.println(end);
        System.out.println("");
        System.out.println("");
    }
}
