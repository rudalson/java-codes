package design.pattern.command;

public class StringPrintCommand implements Command {

    private String string;

    public String getString() {
        return string;
    }

    public StringPrintCommand(String text) {
        string = text;
    }

    @Override
    public void execute() {
        System.out.println(string);
    }

    @Override
    public int compareTo(Command o) {
        StringPrintCommand cmd = (StringPrintCommand) o;
        return string.length() - cmd.getString().length();
    }
}
