package org.study;

import org.kevin.modern02.product.DiscountedProduct;
import org.kevin.modern02.product.Order;
import org.kevin.modern02.product.OrderedItem;
import org.kevin.modern02.product.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class FuncExampleFrom07 {

    public static void main(String[] args) {

        Product productA = new Product(1L, "A", new BigDecimal("10.00"));
        Product productB = new Product(2L, "B", new BigDecimal("55.50"));
        Product productC = new Product(3L, "C", new BigDecimal("17.45"));
        Product productD = new Product(4L, "D", new BigDecimal("20.00"));
        Product productE = new Product(5L, "E", new BigDecimal("110.99"));

        final List<Product> products = Arrays.asList(
                productA,
                productB,
                productC,
                productD,
                productE
        );

        final BigDecimal twenty = new BigDecimal("20");
        System.out.println("products >= $20: " +
                filter(products, product -> product.getPrice().compareTo(twenty) >= 0));

        System.out.println("product s<= $10: " +
                filter(products, product -> product.getPrice().compareTo(new BigDecimal("10")) <= 0));

        final List<Product> expensiveProducts = filter(products, product -> product.getPrice().compareTo(new BigDecimal("50")) > 0);
        final List<DiscountedProduct> discountedProducts =
                map(expensiveProducts, product -> new DiscountedProduct(product.getId(), product.getName(), product.getPrice().multiply(new BigDecimal("0.5"))));
        System.out.println("Expensive  products: " + expensiveProducts);
        System.out.println("Discounted products: " + discountedProducts);
        System.out.println();

        final Predicate<Product> lessThanOrEqualTo30 = p -> p.getPrice().compareTo(new BigDecimal("30")) <= 0;

        System.out.println("discounted products(<= $30): " + filter(discountedProducts, lessThanOrEqualTo30));
        System.out.println("           products(<= $30): " + filter(products, lessThanOrEqualTo30));
        System.out.println();

        final BigDecimal total = total(products, p -> p.getPrice());
        System.out.println("Total           : " + total);

        final BigDecimal discountedTotal = total(discountedProducts, p -> p.getPrice());
        System.out.println("discountedTotal : " + discountedTotal);
        System.out.println();

        Order order = new Order(1L, "on-1234",
                Arrays.asList(
                        new OrderedItem(1L, productA, 2),
                        new OrderedItem(2L, productC, 1),
                        new OrderedItem(3L, productD, 10)
                )
        );

        System.out.println("Ordered total price : " + order.totalPrice());
    }

    static <T> List<T> filter(List<T> list, Predicate<? super T> predicate) {
        final List<T> result = new ArrayList<>();
        for (final T t : list) {
            if (predicate.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    private static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        final List<R> result = new ArrayList<>();
        for (final T t : list) {
            result.add(function.apply(t));
        }

        return result;
    }

    private static <T> BigDecimal total(List<T> list, Function<T, BigDecimal> mapper) {
        BigDecimal total = BigDecimal.ZERO;
        for (final T t : list) {
            total = total.add(mapper.apply(t));
        }
        return total;
    }
}





