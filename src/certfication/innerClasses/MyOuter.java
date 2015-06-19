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
public class MyOuter {

    private final int x = 7;

    public void makeInner() {
        MyInner in = new MyInner(); // make an inner instance
        in.seeOuter();
    }

    class MyInner {

        public void seeOuter() {
            System.out.println("Outer x is " + x);
            System.out.println("Inner class ref is " + this);
            System.out.println("Outer class ref is " + MyOuter.this);
        }

    }

    void doStuff() {
        final String z = "zzz";
        class MyInner2 {
            public void seeOuter() {
                System.out.printf("Outer x * 2 is %d\n", x * 2);
                System.out.println("Local var z is " + z); // z must be final to compile!
            } // close inner class method
        } // close inner class definition
        MyInner2 mi = new MyInner2(); // This line must come after the class
        mi.seeOuter();
    }

    public static void main(String[] args) {
        final MyOuter mo = new MyOuter();
        mo.makeInner();
        mo.doStuff();
    }
}
