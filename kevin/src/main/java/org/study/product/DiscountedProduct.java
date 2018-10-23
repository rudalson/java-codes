package org.study.product;

import java.math.BigDecimal;

public class DiscountedProduct extends Product {
    public DiscountedProduct(Long id, String name, BigDecimal price) {
        super(id, name, price);
    }

    @Override
    public String toString() {
        return "DiscountedProduct{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                '}';
    }
}
