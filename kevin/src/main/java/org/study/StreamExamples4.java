package org.study;

import org.kevin.modern02.product.Product;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class StreamExamples4 {

    public static void main(String[] args) {
        final List<Product> products =
                Arrays.asList(
                        new Product(1L, "A", new BigDecimal("100.50")),
                        new Product(2L, "B", new BigDecimal("23.00")),
                        new Product(3L, "C", new BigDecimal("31.45")),
                        new Product(4L, "D", new BigDecimal("80.20")),
                        new Product(5L, "E", new BigDecimal("7.50"))
                );

        System.out.println("Products.price >= 30:\n" +
                products.stream()
                        .filter(product -> product.getPrice().compareTo(new BigDecimal("30")) >= 0)
                        .collect(toList())
        );

        System.out.println("==========================================");
        System.out.println("Products.price >= 30(with joining:\n" +
                products.stream()
                        .filter(product -> product.getPrice().compareTo(new BigDecimal("30")) >= 0)
                        .map(product -> product.toString())
                        .collect(joining("\n"))
        );

        System.out.println("==========================================");
        System.out.println("Totla Price: " +
                products.stream()
                        .map(product -> product.getPrice())
                        .reduce(BigDecimal.ZERO, (price1, price2) -> price1.add(price2))
        );

        System.out.println("==========================================");
        System.out.println("Totla Price of products.price >= 30: " +
                products.stream()
                        .filter(product -> product.getPrice().compareTo(new BigDecimal("30")) >= 0)
                        .map(product -> product.getPrice())
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
        );
    }
}
