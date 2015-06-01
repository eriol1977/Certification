/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certfication;

/**
 * %[arg_index$][flags][width][.precision]conversion char
 * 
 * arg_index An integer followed directly by a $, this indicates which argument
 * should be printed in this position.
 * flags: 
 * ¦ - Left-justify this argument
 * ¦ + Include a sign (+ or -) with this argument
 * ¦ 0 Pad this argument with zeroes
 * ¦ , Use locale-specific grouping separators (i.e., the comma in 123,456) 
 * ¦ (Enclose negative numbers in parentheses
 * ¦ width This value indicates the minimum number of characters to print. (If you want nice, even columns,
 * you'll use this value extensively.) 
 * precision For the exam, you'll only need this when formatting a floatingpoint
 * number, and in the case of floating-point numbers, precision indicates
 * the number of digits to print after the decimal point.
 * ¦ conversion The type of argument you'll be formatting. 
 * ¦ b boolean 
 * ¦ c char 
 * ¦ d integer 
 * ¦ f floating point 
 * ¦ s string
 * 
*
 */
public class Formatting {

    public static void main(String[] args) {
        // % + 1$ for the first, 2$ for the second + d for integer
        System.out.printf("%2$d + %1$d \n", 123, 456);

        int i1 = -123;
        int i2 = 12345;
        System.out.printf(">%1$(7d< \n", i1);
        System.out.printf(">%0,9d< \n", i2);
        System.out.format(">%+-11d< \n", i2);
        System.out.printf(">%2$b + %1$5d< \n", i1, false);

        double d1 = 2.456;
        double d2 = -43.45678;
        // floating point with 2 decimals
        System.out.printf(">%.2f< \n", d1);
        // floating point in 11 chars with 0 left padding, 3 decimals, and negativity
        // represented with parentheses
        System.out.printf(">%0(11.3f< \n", d2);
        
        System.out.println("");
    }
}
