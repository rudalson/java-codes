package org.study;

import java.util.stream.IntStream;

public class PrimeSample {

    public static boolean isPrimeLegacy(int number) {
        boolean divisible = false;

        for (int i = 2; i < number; ++i) {
            if (number % i == 0) {
                divisible = true;
                break;
            }
        }

        return number > 1 && !divisible;
    }

    public static boolean isPrime(int number) {
        return number > 1 &&
                IntStream.range(2, number)
                        .noneMatch(i -> number % i == 0);
    }

    public static void main(String[] args) {
        for (int i = 1; i < 8; ++i) {
            System.out.printf("isPrime(%d)? %b\n", i, isPrime(i));
        }
    }
}
