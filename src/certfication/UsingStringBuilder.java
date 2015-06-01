/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certfication;

/**
 *
 * @author f.bertolino
 */
public class UsingStringBuilder {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("abc");
        System.out.println(sb);
        sb.append("def");
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
        sb.insert(3, "---");
        System.out.println(sb);
        sb.delete(4,6);
        System.out.println(sb);
    }
}
