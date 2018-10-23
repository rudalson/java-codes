package org.study.java8.grouping;

import org.java8.sorting.Gender;
import org.java8.sorting.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.*;

public class GroupingMain {

    public static List<Person> createPeople() {
        return Arrays.asList(
                new Person("Sara", Gender.FEMALE, 20),
                new Person("Sara", Gender.FEMALE, 22),
                new Person("Bob", Gender.MALE, 20),
                new Person("Paula", Gender.FEMALE, 32),
                new Person("Paul", Gender.MALE, 32),
                new Person("Jack", Gender.MALE, 2),
                new Person("Jack", Gender.MALE, 72),
                new Person("Jill", Gender.FEMALE, 12)
        );
    }

    public static void printSorted(List<Person> people, Comparator<Person> comparator) {
        people.stream()
                .sorted(comparator)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {

        List<Person> people = createPeople();

        System.out.println(
                people.stream()
                .collect(groupingBy(Person::getAge,
                        mapping(Person::getName, toList())))
        );
    }
}
