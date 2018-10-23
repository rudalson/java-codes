package org.study.java8.defaultmethod;

interface Fly {
    default void takeOff() {
        System.out.println("Fly::takeOff");
    }

    default void turn() {
        System.out.println("Fly::turn");
    }

    default void cruise() {
        System.out.println("Fly::cruise");
    }

    default void land() {
        System.out.println("Fly::land");
    }
}

interface FastFly extends Fly {
    default void takeOff() {
        System.out.println("FastFly::takeOff");
    }
}

class Vehicle {
    public void land() {
        System.out.println("Vehicle::land");
    }
}

interface Sail {
    default void cruise() {
        System.out.println("Sail::cruise");
    }
}

class SeaPlane extends Vehicle implements FastFly, Sail {
    public void cruise() {
        System.out.println("SeaPlane::cruise");
        FastFly.super.cruise();
    }
}


// Four rules of default methods
// 1. you get what is in the base interface
// 2/ You may override a default method
// 3. If a method is there in the class hierarchy then it takes precedence
// 4. If there is nomethod on any of the classes in the hierarchy,
// but two of your interfaces that you implements has the default method
// to solve this use rule 3.

public class DefaultMethodMain {

    public void use() {
        SeaPlane seaPlane = new SeaPlane();
        seaPlane.takeOff();
        seaPlane.turn();
        seaPlane.cruise();
        seaPlane.land();
    }

    public static void main(String[] args) {
        new DefaultMethodMain().use();
    }
}
