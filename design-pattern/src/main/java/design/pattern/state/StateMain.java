package design.pattern.state;

public class StateMain {

    public static void main(String[] args) {
        Light light = new Light();

        light.on();
        light.on();
        light.on();

        light.off();
    }
}
