package org.study;

import org.kevin.modern02.product.Product;

import java.math.BigDecimal;

class ProductA extends Product {
    public ProductA(Long id, String name, BigDecimal price) {
        super(id, name, price);
    }

    @Override
    public String toString() {
        return "A=" + super.toString();
    }
}

class ProductB extends Product {
    public ProductB(Long id, String name, BigDecimal price) {
        super(id, name, price);
    }

    @Override
    public String toString() {
        return "B=" + super.toString();
    }
}

@FunctionalInterface
interface ProductCreator<T extends Product> {
    T create(Long id, String name, BigDecimal price);
}

public class MethodReferenceConstructorEx {

    public static void main(String[] args) {

        final ProductA a = createProduct(1L, "A", new BigDecimal("123"), ProductA::new);
        final ProductB b = createProduct(2L, "B", new BigDecimal("234"), ProductB::new);

        System.out.println(a);
        System.out.println(b);
    }

    private static <T extends Product> T createProduct(final Long id,
                                                final String name,
                                                final BigDecimal price,
                                                final ProductCreator<T> productCreator) {
        return productCreator.create(id, name, price);
    }
}
