package design.pattern.command;

import java.util.PriorityQueue;

public class CommandMain {

    public static void main(String[] args) {

        PriorityQueue<Command> q = new PriorityQueue<>();

        q.add(new StringPrintCommand("ABCD"));
        q.add(new StringPrintCommand("ABC"));
        q.add(new StringPrintCommand("AB"));
        q.add(new StringPrintCommand("A"));

        for (Command command : q) {
            command.execute();
        }
    }
}
