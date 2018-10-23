package design.pattern.chainofresponsibility;

public abstract class Calculator {

    private Calculator next;

    public void setNextCalcultor(Calculator next) {
        this.next = next;
    }

    public boolean process(Request request) {

        if (operator(request)) {
            return true;
        } else {
            return next.process(request);
        }
    }

    abstract protected boolean operator(Request request);
 }
