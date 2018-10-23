package org.study.product;

import java.math.BigDecimal;
import java.util.List;

public class Order {
    private Long id;
    private String orderNumber;
    private List<OrderedItem> items;

    public Order(Long id, String orderNumber, List<OrderedItem> items) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.items = items;
    }

    public BigDecimal totalPrice() {
        return items.stream()
                .map(item -> item.getProduct().getPrice().multiply(new BigDecimal(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
//                .reduce(BigDecimal.ZERO, (price1, price2) -> price1.add(price2));
    }
}
