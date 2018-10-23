package org.study.java8.mapconvenience;

import java.util.HashMap;
import java.util.Map;

public class MapConvenienceMain {

    public static double compute(int number) {
        System.out.println("called...");
        return Math.sqrt(number);
    }

    public static void main(String[] args) {

        Map<Integer, Double> sqrt = new HashMap<>();

//        if (!sqrt.containsKey(4)) {
//            sqrt.put(4, compute(4));
//        }

        sqrt.computeIfAbsent(4, MapConvenienceMain::compute);

        System.out.println(sqrt.get(4));


    }
}
