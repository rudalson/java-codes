package org.study.java8.stringjoin;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class StringJoiningMain {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Tom", "Jerry", "Jane", "Jack");

        System.out.println(names.stream().map((String::toUpperCase)).collect(joining(", ")));
    }
}
