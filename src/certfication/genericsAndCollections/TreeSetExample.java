/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certfication.genericsAndCollections;

import java.util.Comparator;
import java.util.Objects;
import java.util.TreeSet;

/**
 *
 * @author f.bertolino
 */
public class TreeSetExample {

    public static void main(String[] args) {
        TreeSet<Integer> times = new TreeSet<>();
        times.add(1545);
        times.add(1205);
        times.add(1505);
        times.add(2010);
        times.add(1830);
        times.add(1600);
        times.add(2100);
        times.add(2000);
        System.out.println(times);

        // Java 5 version
        TreeSet<Integer> subset;
        subset = (TreeSet) times.headSet(1600);
        System.out.println("J5 - last before 4pm is: " + subset.last());
        TreeSet<Integer> sub2;
        sub2 = (TreeSet) times.tailSet(2000);
        System.out.println("J5 - first after 8pm is: " + sub2.first());

        // Java 6 version using the new lower() and higher() methods
        System.out.println("J6 - last before 4pm is: " + times.lower(1600));
        System.out.println("J6 - first after 8pm is: " + times.higher(2000));
        System.out.println("J6 - last before/at 4pm is: " + times.floor(1600));
        System.out.println("J6 - first after/at 8pm is: " + times.ceiling(2000));

        System.out.println("Original tree: " + times);
        System.out.println(times.pollFirst());
        System.out.println(times.pollFirst());
        System.out.println("After polling firsts: " + times);
        System.out.println(times.pollLast());
        System.out.println(times.pollLast());
        System.out.println("After polling lasts: " + times);

        System.out.println("In ordine discendente: " + times.descendingSet());
        
        TreeSet<Dog> dogSet = new TreeSet<>();
        dogSet.add(new Dog(10));
        dogSet.add(new Dog(3));
        dogSet.add(new Dog(5));
        dogSet.add(new Dog(1));
        System.out.println(dogSet);
        
        TreeSet<Dog> inverseDogSet = new TreeSet<>(new InverseDogComparator());
        inverseDogSet.add(new Dog(10));
        inverseDogSet.add(new Dog(3));
        inverseDogSet.add(new Dog(5));
        inverseDogSet.add(new Dog(1));
        System.out.println(inverseDogSet);
    }

    static class Dog implements Comparable<Dog> {

        private final Integer size;

        public Dog(Integer size) {
            this.size = size;
        }

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 31 * hash + this.size;
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Dog other = (Dog) obj;
            return Objects.equals(this.size, other.size);
        }

        public Integer getSize() {
            return size;
        }

        @Override
        public int compareTo(Dog o) {
            return this.size.compareTo(o.getSize());
        }

        @Override
        public String toString() {
            return "Size: " + this.size;
        }
    }
    
    static class InverseDogComparator implements Comparator<Dog>
    {

        @Override
        public int compare(Dog o1, Dog o2) {
            return o2.compareTo(o1);
        }
        
    }
}
