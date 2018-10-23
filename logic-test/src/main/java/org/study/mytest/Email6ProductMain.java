package org.study.mytest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

class ProductFinder2 {
    public List<Product2> findByProductIdIn(List<Long> productIds) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //return Optional.empty();
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

    static List<Long> products = Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L);
    static ProductFinder2 productFinder = new ProductFinder2();

    public static void main(String[] args) {
        List<Product2> productList = productFinder.findByProductIdIn(products);

        if (productList.size() != products.size()) {
            System.err.println("There is nonexistenct product(s)");
            return;
        }

        if (productList.stream().anyMatch(pr -> !pr.getValid())) {
            System.err.println("there is unavailable product(s)");
            return;
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
