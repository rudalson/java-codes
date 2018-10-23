package org.study.lambda.sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class ValidatorMain {

    public static void main(String[] args) {

        List<ProductTarget> targetList = Arrays.asList(
                new ProductTarget(2L, 40100551L, 1L, 4L, 1L),
                new ProductTarget(2L, 40100564L, 2L, 7L, 2L),
                new ProductTarget(3L, 40100711L, 1L, 3L, 1L),
                new ProductTarget(3L, 40100736L, 2L, 6L, 0L),
                new ProductTarget(1L, 40100852L, 2L, 8L, 5L),
                new ProductTarget(1L, 40100944L, 1L, 5L, 0L)
        );

        List<ProductTarget> targetList2 = targetList.stream()
                .sorted(comparing(ProductTarget::getKws_rank).thenComparing(ProductTarget::getKw_prod_rnk))
                .collect(Collectors.toList());

        List<ProductPackage> packages = targetList2.stream()
                .map(target -> new ProductPackage(target.getProductid(), target.getStar_score(), target.getComment_count()))
                .collect(Collectors.toList());

        System.out.println(targetList);
        System.out.println(targetList2);
        System.out.println(targetList == targetList2);

        System.out.println(packages);
    }
}
