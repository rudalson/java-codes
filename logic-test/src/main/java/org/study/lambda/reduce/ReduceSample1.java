package org.study.lambda.reduce;

import java.util.Arrays;
import java.util.List;

/*
JDK 8: Lessons Learnt With Lambdas and Streams 참조
https://youtu.be/wZKmA6XodNE
*/
class Offer {
    private  int id;

    public Offer(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

public class ReduceSample1 {

    public static void main(String[] args) {
        List<Offer> offers = Arrays.asList(
                new Offer(1),
                new Offer(2),
                new Offer(3),
                new Offer(4),
                new Offer(5)
        );

        // type1
        Offer latest = offers.stream()
                .reduce((o1, o2) -> {
                    if(o1.getId() > o2.getId())
                        return o1;
                    return o2;
                })
                .get();

        // type2
        Offer latest2 = offers.stream()
                .max((o1, o2) -> (o2.getId() - o1.getId()))
                .get();

        System.out.println(latest.getId());
        System.out.println(latest2.getId());
    }
}
