package org.study.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ReverseFind {

    public static void main(String[] args) {
        List<String> valueList = new ArrayList<>();
        valueList.add("Joe");
        valueList.add("John");
        valueList.add("Sean");
        valueList.add("Wang");

        Stream<String> stream = valueList.stream();
        String last = stream.reduce((first, second) -> second)
                .orElse(null);

        System.out.println(last);
    }
}
