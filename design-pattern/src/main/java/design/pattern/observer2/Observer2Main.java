package design.pattern.observer2;

import java.util.Observable;
import java.util.Observer;

public class Observer2Main {

    public static void main(String[] args) {
        Button button = new Button();

        button.addObserver(new Observer() {

            @Override
            public void update(Observable o, Object arg) {
                System.out.println(arg + " is clicked. " + o);
            }
        });

        button.onClick();
        button.onClick();
        button.onClick();
    }
}
