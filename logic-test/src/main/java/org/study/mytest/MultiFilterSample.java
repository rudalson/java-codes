package org.study.mytest;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

class AdultProduct implements Predicate<Long> {

    @Override
    public boolean test(Long product) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return (7L == product);
    }
}

class BlackProduct implements Predicate<Long> {

    @Override
    public boolean test(Long product) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return (7L == product);
    }
}

class Prod {
    Long id;
    String name;

    public Prod(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}

class ProductFinder {
    public Optional<Prod> findByProductId(long productId) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //return Optional.empty();
        return Optional.of(new Prod(productId, "화장품"));
    }
}

public class MultiFilterSample {

    static AdultProduct adultProduct = new AdultProduct();
    static BlackProduct blackProduct = new BlackProduct();
    static ProductFinder productFinder = new ProductFinder();

    public static void main(String[] args) {

        final List<Long> products = Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L);

        long now = System.currentTimeMillis();
        boolean result = validate(products);

        System.out.println("elapsed " + (System.currentTimeMillis() - now)+ " ms. result : " + result );
    }

    public static void create(final List<Long> products) {

//        products.stream().filter(pid -> productFinder.findByProductId(pid).isPresent())

    }

    public static boolean validate(final List<Long> products) {
        if (products.parallelStream().anyMatch(adultProduct)) {
            System.out.println("Adult exist");
            return false;
        }

        if (products.parallelStream().anyMatch(blackProduct)) {
            System.out.println("black exist");
            return false;
        }

        return true;
    }
}
