package lambda.style;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LightweightSample {

    static public int totalValues(List<Integer> values) {
        int result = 0;

        for (int e : values) {
            result += e;
        }

        return result;
    }

    static public int totalValues2(List<Integer> values, Predicate<Integer> selector) {
        int result = 0;

        for (int e : values) {
            if (selector.test(e))
                result += e;
        }

        return result;
    }

    static public int totalValues3(List<Integer> values, Predicate<Integer> selector) {
//        return values.stream()
//                .filter(selector)
//                .reduce(0, Integer::sum)
//                ;

        return values.stream()
                .filter(selector)
                .mapToInt(e -> e)
                .sum()
                ;

        // 둘다 같음
    }

    public static void main(String[] args) {
        execute1();
        System.out.println();

        execute2();
        System.out.println();

        execute3();
        System.out.println();

        execute4();
        System.out.println();
    }

    static public void execute1() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println(totalValues(numbers));
//        System.out.println(totalEnenValues(numbers)); // 일일이 만들꺼임?
//        System.out.println(totalOddValues(numbers));  // 또?
    }

    static public void execute2() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println(totalValues2(numbers, e -> true));
        System.out.println(totalValues2(numbers, e -> e % 2 == 0));
        System.out.println(totalValues2(numbers, e -> e % 2 == 1));
    }

    static public void execute3() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println(totalValues3(numbers, e -> true));
        System.out.println(totalValues3(numbers, e -> e % 2 == 0));
        System.out.println(totalValues3(numbers, e -> e % 2 == 1));
        // 이 함수는 같은에 위에 totalValues3에서 lambda형태로 변경되었음
    }

    static public void execute4() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println(totalValues3(numbers, e -> true));
        System.out.println(totalValues3(numbers, Util::isEven));
        System.out.println(totalValues3(numbers, Util::isOdd));
        // 위의 람다함수 자체를 재활용 하기 위해 아래의 Util 클래스를 만듬
    }
}

class Util {
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static boolean isOdd(int number) {
        return number % 2 == 1;
    }
}