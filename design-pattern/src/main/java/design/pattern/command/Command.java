package design.pattern.command;

public interface Command extends Comparable<Command> {
    void execute();
}
