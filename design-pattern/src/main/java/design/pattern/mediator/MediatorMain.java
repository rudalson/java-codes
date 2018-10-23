package design.pattern.mediator;

public class MediatorMain {

    public static void main(String[] args) {

        Mediator mediator = new ChatMediator();

        Colleague col1 = new ChatColleague();
        Colleague col2 = new ChatColleague();
        Colleague col3 = new ChatColleague();

        col1.join(mediator);
        col2.join(mediator);
        col3.join(mediator);

        col1.sendData("AAA");
        col2.sendData("BBB");
        col3.sendData("CCC");
    }
}
