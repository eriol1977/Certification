/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certfication.innerClasses;

/**
 *
 * @author f.bertolino
 */
public class AnotherClass {

    public static void main(String[] args) {
        MyOuter mo = new MyOuter(); // gotta get an instance!
        MyOuter.MyInner inner = mo.new MyInner();
        // or: MyOuter.MyInner inner = new MyOuter().new MyInner();
        inner.seeOuter();
    }
}
