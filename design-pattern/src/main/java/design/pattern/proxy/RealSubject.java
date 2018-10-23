package design.pattern.proxy;

public class RealSubject implements Subject {
    @Override
    public void action1() {
        System.out.println("Simple work by Real");
    }

    @Override
    public void action2() {
        System.out.println("Complex work by Real");
    }
}
