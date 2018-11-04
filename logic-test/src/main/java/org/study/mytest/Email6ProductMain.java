package org.study.mytest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.util.stream.Collectors.toList;

class Product2 {
    Long id;
    Boolean valid;

    public Product2(Long id, Boolean valid) {
        this.id = id;
        this.valid = valid;
    }

    public Long getId() {
        return id;
    }

    public Boolean getValid() {
        return valid;
    }

    @Override
    public String toString() {
        return "Product2{" +
                "id=" + id +
                ", valid=" + valid +
                '}';
    }
}

@AllArgsConstructor
@Setter
@Getter
class VendorItem {
    long id;
    long productId;
    Boolean valid;
    Boolean logistics;
    Boolean soldOut;
}

class VendorItemFinder {
    static public List<VendorItem> findByProductIdIn(List<Long> productIds) {
        return Arrays.asList(
                new VendorItem(1L, 1L, TRUE, TRUE, FALSE), new VendorItem(2L, 1L, TRUE, TRUE, FALSE),
                new VendorItem(3L, 2L, TRUE, FALSE, FALSE), new VendorItem(4L, 2L, TRUE, FALSE, FALSE),
                new VendorItem(5L, 3L, TRUE, TRUE, FALSE), new VendorItem(6L, 3L, TRUE, TRUE, FALSE),
                new VendorItem(7L, 4L, TRUE, TRUE, TRUE), new VendorItem(8L, 4L, TRUE, TRUE, TRUE),
                new VendorItem(9L, 5L, TRUE, TRUE, FALSE), new VendorItem(10L, 5L, TRUE, TRUE, FALSE),
                new VendorItem(11L, 6L, TRUE, TRUE, FALSE), new VendorItem(12L, 6L, TRUE, TRUE, FALSE)
        );
    }
}

class ProductFinder2 {
    public List<Product2> findByProductIdIn(List<Long> productIds) {
        return Arrays.asList(new Product2(1L, TRUE), new Product2(2L, TRUE), new Product2(3L, TRUE), new Product2(4L, TRUE), new Product2(5L, TRUE), new Product2(6L, TRUE));
    }
}

class EmailProductInfo {
    Long id;
    String imageUrl;
    String opt1;

    public EmailProductInfo(Long id, String imageUrl, String opt1) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.opt1 = opt1;
    }

    @Override
    public String toString() {
        return "EmailProductInfo{" +
                "id=" + id +
                ", imageUrl='" + imageUrl + '\'' +
                ", opt1='" + opt1 + '\'' +
                '}';
    }
}

public class Email6ProductMain {

    static List<Long> productIds = Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L);
    static ProductFinder2 productFinder = new ProductFinder2();

    public static void main(String[] args) {
        List<Product2> productList = productFinder.findByProductIdIn(productIds);

        if (productList.size() != productIds.size()) {
            System.err.println("There is nonexistenct product(s)");
            return;
        }

        if (productList.stream().anyMatch(pr -> {
            if (!pr.getValid()) {
                System.err.println("there is an unavailable product : " + pr.id);
            }
            return !pr.getValid();
        })) {
            return;
        }

        List<VendorItem> vendorItems = VendorItemFinder.findByProductIdIn(productIds);

        for (Long id : productIds) {
            List<VendorItem> vis = vendorItems.stream().filter(v -> v.getProductId()==id).collect(toList());

            if (vis.parallelStream().allMatch(VendorItem::getSoldOut)) {
                System.err.println("there is not vendor items. product :" + id);
                return;
            }

            if (vis.parallelStream().noneMatch(VendorItem::getValid)) {
                System.err.println("there is not available vendor item. product :" + id);
                return;
            }
        }






        Optional<Product2> optional = productList.stream().filter(pr -> pr.getId() == 7L).findFirst();

        long start = System.currentTimeMillis();
        ArrayList<EmailProductInfo> productInfos =
                (ArrayList<EmailProductInfo>) productList.parallelStream()
                        .map(pr -> new EmailProductInfo(pr.getId(), getImageUrl(pr.getId()), getRocketDeliveryInfo(pr.getId())))
                        .collect(toList());

        System.out.println("Elapsed " + (System.currentTimeMillis() - start) + "ms");
        System.out.println(productInfos.toString());
    }

    public static String getImageUrl(final Long productId) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "http://";
    }

    private static String getRocketDeliveryInfo(Long id) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "http://";
    }
}
