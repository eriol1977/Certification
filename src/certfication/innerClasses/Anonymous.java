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
public class Anonymous {

    class Popcorn {

        public void pop() {
            System.out.println("popcorn");
        }
    }

    class Food {

        Popcorn p = new Popcorn() {
            public void sizzle() {
                System.out.println("anonymous sizzling popcorn");
            }

            @Override
            public void pop() {
                System.out.println("anonymous popcorn");
            }
        };

        public void popIt() {
            p.pop(); // OK, Popcorn has a pop() method
            //p.sizzle(); // Not Legal! Popcorn does not have sizzle()
        }
    }

    interface Cookable {
        public void cook();
    }

    class Egg {

        Cookable c = new Cookable() {
            @Override
            public void cook() {
                System.out.println("anonymous cookable implementer");
            }
        };

        public void cookIt() {
            c.cook();
        }
    }

    public static void main(String[] args) {
        final Anonymous a = new Anonymous();
        a.new Popcorn().pop();
        a.new Food().popIt();
        a.new Egg().cookIt();
    }
}
