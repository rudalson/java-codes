package design.pattern.mediator;

public class ChatMediator extends Mediator {

    @Override
    public void mediate(String data) {

        for (Colleague col : colleagues) {
            col.handle(data);
        }
    }
}
