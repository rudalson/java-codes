package org.study.java8.staticinterface;

interface Util {
    public static int numberOfCores() {
        return Runtime.getRuntime().availableProcessors();
    }
}

public class StaticInterfaceMain {

    public static void main(String[] args) {
        System.out.println(Util.numberOfCores());
    }
}
