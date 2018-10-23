package org.study;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class StreamExample02 {

    final static List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    public static void main(String[] args) {

        streamCollect();

        streamfind();
    }

    static void streamCollect() {
        System.out.println("collect(toList()): " +
                Stream.of(1, 2, 3, 4, 5)
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "#" + i)
                        .collect(toList())
        );

        System.out.println("collect(toSet()): " +
                Stream.of(1, 3, 3, 5, 5)
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "#" + i)
                        .collect(toSet())
        );

        System.out.println("collect(joining()): " +
                Stream.of(1, 3, 3, 5, 5)
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "#" + i)
                        .collect(joining(", "))
        );

        System.out.println("collect(joining()): " +
                Stream.of(1, 3, 3, 5, 5)
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "#" + i)
                        .collect(joining(", ", "[", "]"))
        );

        System.out.println("distinct().collect(joining()): " +
                Stream.of(1, 3, 3, 5, 5)
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "#" + i)
                        .distinct()
                        .collect(joining(", "))
        );

        System.out.println("distinct().collect(toList()): " +
                Stream.of(1, 3, 3, 5, 5)
                        .filter(i -> i > 2)
                        .map(i -> i * 2)
                        .map(i -> "#" + i)
                        .distinct()
                        .collect(toList())
        );
    }

    static void streamfind() {
        System.out.println("same 3: " +
                Stream.of(1, 3, 3, 5, 5)
                        .filter(i -> i == 3)
                        .findFirst()
        );

    }

}
