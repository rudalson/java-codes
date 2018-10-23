package org.study;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SumOfSqrtPrimesSample {

    private static boolean isPrime(int number) {
        return number > 1 &&
                IntStream.range(2, number)
                        .noneMatch(i -> number % i == 0);
    }

    private static double computeSumOfSqrtOfPrimesLegacy(int start, int count) {
        int index = start;
        int computedCount = 0;
        double sum = 0;

        while (computedCount < count) {
            if (isPrime(index)) {
                sum += Math.sqrt(index);
                computedCount++;
            }
            index++;
        }

        return sum;
    }

    private static double computeSumOfSqrtOfPrimes(int start, int count) {
        return Stream.iterate(start, e -> e + 1)
                .filter(SumOfSqrtPrimesSample::isPrime)
                .mapToDouble(Math::sqrt)
                .limit(count)
                .sum();
    }

    public static void main(String[] args) {
        System.out.println(computeSumOfSqrtOfPrimes(101, 51));
    }
}
