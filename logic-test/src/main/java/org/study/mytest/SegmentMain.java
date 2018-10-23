package org.study.mytest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class SegmentMain {
    public static void main(String[] args) {

        List<EmailProductTarget> list = Arrays.asList(
                new EmailProductTarget(3, 104, 1),
                new EmailProductTarget(2, 102, 1),
                new EmailProductTarget(3, 105, 2),
                new EmailProductTarget(1, 101, 2),
                new EmailProductTarget(2, 103, 2),
                new EmailProductTarget(1, 100, 1)
        );

        List<Long> products = list.stream()
                .sorted(comparing(EmailProductTarget::getKws_rank).thenComparing(EmailProductTarget::getKw_prod_rnk))
                .map(target -> target.getProductid())
                .collect(Collectors.toList());

        System.out.println(products);
    }
}
