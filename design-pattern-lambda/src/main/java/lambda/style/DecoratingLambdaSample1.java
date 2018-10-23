package lambda.style;

import java.util.function.Function;

public class DecoratingLambdaSample1 {

    public static void doWork(int value, Function<Integer, Integer> func) {
        System.out.println(func.apply(value));
    }

    public static void main(String[] args) {
        Function<Integer, Integer> inc = e -> e + 1;
        Function<Integer, Integer> doubleIt = e -> e * 2;

        doWork(5, inc);
        doWork(5, doubleIt);

        // don't do this
        int temp = inc.apply(5);
        System.out.println(doubleIt.apply(temp));

        // do it. andThen 쓴 것에 주목
        doWork(5, inc.andThen(doubleIt));
    }
}
