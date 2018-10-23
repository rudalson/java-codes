package design.pattern.chainofresponsibility;

public class ChainOfReponsibilityMain {

    public static void main(String[] args) {

        Calculator calculator = new PlusCalculator();

        calculator.setNextCalcultor(new SubCalculator());

        Request request1 = new Request(1, 2, "+");
        Request request2 = new Request(10, 2, "-");

        calculator.process(request1);
        calculator.process(request2);
    }
}
