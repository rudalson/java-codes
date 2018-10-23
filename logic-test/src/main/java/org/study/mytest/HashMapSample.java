package org.study.mytest;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class HashMapSample {
    static int offset = 101;
    static LinkedHashMap<Integer, Boolean> map = new LinkedHashMap<>();

    public static void main(String[] args) {

        for (int i = 101; i <= 110; ++i) {
            addEmailCandidateOffer(i);
        }

        addEmailCandidateOffer(101);

        map.put(103, true);
        checkOffset();
        map.put(102, true);
        checkOffset();
        map.put(101, true);
        checkOffset();
        map.put(105, true);
        checkOffset();
        addEmailCandidateOffer(105);
        map.put(104, true);
        checkOffset();


    }

    public static void checkOffset() {

        Iterator<Map.Entry<Integer, Boolean>> mapIterator = map.entrySet().iterator();

        while (mapIterator.hasNext()) {
            Map.Entry<Integer, Boolean> entry = mapIterator.next();
            if (entry.getValue()) {
                offset = entry.getKey();
                mapIterator.remove();
            } else {
                break;
            }
        }

        System.out.println("\noffset is " + offset);
        System.out.println(map.toString());
    }

    public static void addEmailCandidateOffer(final int id) {
        Boolean ret = map.putIfAbsent(id, false);
        System.out.println("id(" + id + ") return " + ret);
    }
}
