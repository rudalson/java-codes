package design.pattern.visitor;

import java.util.ArrayList;
import java.util.List;

public class VisitorMain {

    public static void main(String[] args) {

        List<Visitable> visitables = new ArrayList<>();

        visitables.add(new VisitableA(1));
        visitables.add(new VisitableA(2));
        visitables.add(new VisitableA(3));
        visitables.add(new VisitableA(4));
        visitables.add(new VisitableA(5));

        Visitor visitor = new VisitorA();

        for (Visitable visitable : visitables) {
            visitable.accept(visitor);
        }

        System.out.println(((VisitorA) visitor).getAgeSum());
    }
}
