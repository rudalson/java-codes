package org.study;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceExamples {

    public static void main(String[] args) {

        // 1. Function
//        functionExample();

        // 2. Cosumer
//        consumerExample();

        // 3. Predicate
//        predicateExample();

        // 4. Supplier
//        supplierExample();

        // 5. 나만의 Functional Interface
//        myFunctionalExample();

        // 6. Functional Interface Constraint
        functionalInterfaceConstraint();
    }

    static void functionalInterfaceConstraint() {
        BigDecimalToCurrency bigDecimalToCurrency = bd -> "$" + bd.toString();
        System.out.println(bigDecimalToCurrency.toCurrency(new BigDecimal("120.00")));
    }

    static void myFunctionalExample() {
        print3(1, 2, 3, (i1, i2, i3) -> String.valueOf(i1 + i2 + i3));

        print3("Area is ", 12, 20, (message, length, width) -> message + length * width);

        print3(1L, "Kevin ", "test@email.com", (id, name, email) -> "User info: ID=" + id + ", name=" + name + ", email=" + email);
    }

    static <T1, T2, T3> void print3(T1 t1, T2 t2, T3 t3, Function3<T1, T2, T3, String> function) {
        System.out.println(function.apply(t1, t2, t3));
    }

    // lazy evaludation 할 때 쓰는 편
    static void supplierExample() {
        final Supplier<String> helloSupplier = () -> "Hello ";

        System.out.println(helloSupplier.get() + "world");

        long start = System.currentTimeMillis();
        printIfValidIndex(0, getVeryExpensiveValue());
        printIfValidIndex(-51, getVeryExpensiveValue());
        printIfValidIndex(-1, getVeryExpensiveValue());
        System.out.println("It took " + (System.currentTimeMillis()-start) / 1000);

        start = System.currentTimeMillis();
        printIfValidIndex2(0, () -> getVeryExpensiveValue());
        printIfValidIndex2(-51, () -> getVeryExpensiveValue());
        printIfValidIndex2(-1, () -> getVeryExpensiveValue());
        System.out.println("It took " + (System.currentTimeMillis()-start) / 1000);
    }

    static String getVeryExpensiveValue() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Kevin";
    }

    static void printIfValidIndex(int number, String value) {
        if (number >= 0) {
            System.out.println("The value is " + value + ".");
        } else {
            System.out.println("Invalid");
        }
    }

    static void printIfValidIndex2(int number, Supplier<String> valueSupplier) {
        if (number >= 0) {
            System.out.println("The value is " + valueSupplier.get() + ".");
        } else {
            System.out.println("Invalid");
        }
    }

    static void functionExample() {
        Function<String, Integer> toInt = (value) -> Integer.parseInt(value);

        final Integer number = toInt.apply("100");

        System.out.println(number);

        final Function<Integer, Integer> identity = Function.identity();

        System.out.println(identity.apply(999));
    }

    static void consumerExample() {
        final Consumer<String> print = value -> System.out.println(value);
        final Consumer<String> greetings = value -> System.out.println("Hello " + value);

        print.accept("Hello");
        greetings.accept("rudalson");
    }

    static void predicateExample() {
        Predicate<Integer> isPositive = n -> n > 0;

        System.out.println(isPositive.test(1));
        System.out.println(isPositive.test(0));
        System.out.println(isPositive.test(-1));

        List<Integer> numbers = Arrays.asList(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5);

        List<Integer> positiveNumbers = new ArrayList<>();
        for (Integer num : numbers) {
            if (isPositive.test(num)) {
                positiveNumbers.add(num);
            }
        }
        System.out.println("Positive integers : " + positiveNumbers);

        Predicate<Integer> lessThan3 = n -> n < 3;
        List<Integer> numbersLessThan3 = new ArrayList<>();
        for (Integer num : numbers) {
            if (lessThan3.test(num)) {
                numbersLessThan3.add(num);
            }
        }
        System.out.println("lessThan3 integers : " + numbersLessThan3);

        // 이런식으로 하면 람다 빼곤 다 중복된 코드라서 아래의 filter 같은 함수를 만들었다.
        System.out.println("Simple Positive integers : " + filter(numbers, isPositive));
        System.out.println("Simple lessThan3 integers : " + filter(numbers, n -> n < 3));
    }

    static <T> List<T> filter(List<T> list, Predicate<T> filter) {
        List<T> result = new ArrayList<>();

        for (T value : list) {
            if (filter.test(value)) {
                result.add(value);
            }
        }
        return result;
    }
}

@FunctionalInterface
interface Function3<T1, T2, T3, R> {
    R apply(T1 t1, T2 t2, T3 t3);

//    void print(int i); // functionalinterface 는 함수가 1개여야만 한다.
}

@FunctionalInterface
interface BigDecimalToCurrency {
    String toCurrency(BigDecimal value);
    // 이렇게 generic이 아닌 명시적인 type이 들어오는 형태도 괜찮다. 하지만
    // <T> String toString(T value);
    // 처럼 내부에서 Generic형태로 작성한 경우는 여기서는 에러가 나지 않지만 사용할 때는 에러가 난다.
}