package org.study;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StreamExample01 {

    final static List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    public static void main(String[] args) {

//        makeUnlimitNumber();

        executeStream();

        executeOwn();
    }

    static void makeUnlimitNumber() {
        IntStream.rangeClosed(1, 10)
                .forEach(i -> System.out.print(i + " "));

        // Java 에서 무한대 만들기
        IntStream.iterate(1, i -> i + 1)
                .forEach(i -> System.out.print(i + " "));

        Stream.iterate(BigInteger.ONE, i -> i.add(BigInteger.ONE))
                .forEach(i -> System.out.print(i + " "));
    }

    static void executeStream() {
//        Stream.of(1, 2, 3, 4, 5).forEach(i -> System.out.print(i + " "));

        System.out.println(
                numbers.stream()
                        .filter(number -> number > 3)
                        .filter(number -> number < 9)
                        .map(number -> number * 2)
                        .filter(number -> number > 10)
                        .findFirst()
        );

        System.out.println(
                numbers.stream()
                        .filter(number -> number > 3)
                        .filter(number -> number < 9)
                        .collect(toList())
        );

        //stream은 게으르게 동작한다.
    }

    static void executeOwn() {
        final List<Integer> greaterThan3 = filter(numbers, i -> i > 3);
        final List<Integer> lessThan9 = filter(greaterThan3, i -> i < 9);
        final List<Integer> doubled = map(lessThan9, i -> i * 2);
        final List<Integer> greaterThan10 = filter(doubled, i -> i > 10);
        System.out.println(greaterThan10.get(0));
        // 위의 방식과는 약간 틀리다. 위에 께 효율이 더 좋다
    }


    static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        final List<T> result = new ArrayList<>();
        for (final T t : list) {
            if (predicate.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    static <T, R> List<R> map(List<T> list, Function<T, R> mapper) {
        final List<R> result = new ArrayList<>();
        for (final T t : list) {
            result.add(mapper.apply(t));
        }

        return result;
    }
}
