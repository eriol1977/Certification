/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certfication.genericsAndCollections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author f.bertolino
 */
public class MyGeneric {

    public static void main(String[] args) {
        //make some Cars for the pool
        Car c1 = new Car();
        Car c2 = new Car();
        List<Car> carList = new ArrayList<>();
        carList.add(c1);
        carList.add(c2);
        RentalGeneric<Car> carRental = new RentalGeneric<>(carList);
        // now get a car out, and it won't need a cast
        Car carToRent = carRental.getRental();
        carRental.returnRental(carToRent);

        // do the same with Bikes
        Bike b1 = new Bike();
        Bike b2 = new Bike();
        Bike b3 = new Bike();
        List<Bike> bikes = new ArrayList<>();
        bikes.add(b1);
        bikes.add(b2);
        bikes.add(b3);
        RentalGeneric<Bike> bikeRental = new RentalGeneric<>(bikes);
        Bike bikeToRent = bikeRental.getRental();
        bikeRental.returnRental(bikeToRent);

        // another example
        System.out.println(new StringifyTwo(12, "Pippo"));
        System.out.println(new StringifyTwo(new Car(), new Bike()));
        System.out.println(new StringifyTwo("Ciccio", new Car()));

        // generic method
        List<Bike> otherBikes = makeArrayList(b1, b2, b3);
        System.out.println(otherBikes);
        
        List<Car> otherCars = makeArrayList(c1, c2);
        System.out.println(otherCars);
        
        Map<Integer, Bike> bikeMap = makeVehicleMap(b1, b2, b3);
        System.out.println(bikeMap);
        
        Map<Integer, Car> carMap = makeVehicleMap(c1, c2);
        System.out.println(carMap);
        
        //makeVehicleMap(1,2,3); non compila perchè Integer non implementa Vehicle!
    }

    private static <T> List<T> makeArrayList(T... elements) {
        final List<T> list = new ArrayList<>();
        for (final T element : elements) {
            list.add(element);
        }
        return list;
    }

    private static <X extends Vehicle> Map<Integer,X> makeVehicleMap(X... vehicles)
    {
        final Map<Integer,X> map = new HashMap<>();
        int i=0;
        for(X v: vehicles)
            map.put(++i,v);
        return map;
    }
    
    static class RentalGeneric<T> { // "T" is for the type parameter

        private final List<T> rentalPool; // Use the class type for the List type

        public RentalGeneric(List<T> rentalPool) { // constructor takes a List of the class type
            this.rentalPool = rentalPool;
        }

        public T getRental() { // we rent out a T blocks until there's something available
            return rentalPool.get(0);
        }

        public void returnRental(T returnedThing) { // and the renter returns a T
            rentalPool.add(returnedThing);
        }
    }

    static class StringifyTwo<T, X> {

        T one;
        X two;

        public StringifyTwo(T one, X two) {
            this.one = one;
            this.two = two;
        }

        @Override
        public String toString() {
            return one.toString() + "/" + two.toString();
        }

        public T getOne() {
            return one;
        }

        public X getTwo() {
            return two;
        }

    }

    static interface Vehicle{};
    
    static class Car implements Vehicle {

        @Override
        public String toString() {
            return "WROOM!";
        }

    }

    static class Bike implements Vehicle {

        @Override
        public String toString() {
            return "PEDAL, PEDAL!";
        }
    }
}
