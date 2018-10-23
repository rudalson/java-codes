package org.study.product;

public class OrderedItem {
    private Long id;
    private Product product;
    private int quantity;

    public OrderedItem(Long id, Product product, int quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
