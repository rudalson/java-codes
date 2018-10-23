package design.pattern.abstractfactory.concrete;

import org.study.abstractfactory.Button;
import org.study.abstractfactory.GuiFactory;
import org.study.abstractfactory.TextArea;

public class FactoryInstance {

    public static GuiFactory getGuiFactory(String os) {

        String o = os.toLowerCase();

        switch(o) {
            case "linux": return new LinuxFactory();
            case "mac os x" : return new MacFactory();
        }

        return null;
    }
}

class LinuxButton implements Button {
    @Override
    public void click() {
        System.out.println("linux button");
    }
}

class LinuxTextArea implements TextArea {
    @Override
    public String getText() {
        return "linux text area";
    }
}

class LinuxFactory implements GuiFactory {
    @Override
    public Button createButton() {
        return new LinuxButton();
    }

    @Override
    public TextArea createTextArea() {
        return new LinuxTextArea();
    }
}

class MacButton implements Button {
    @Override
    public void click() {
        System.out.println("Mac button");
    }
}

class MacTextArea implements TextArea {
    @Override
    public String getText() {
        return "Mac Text Area";
    }
}

class MacFactory implements GuiFactory {

    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public TextArea createTextArea() {
        return new MacTextArea();
    }
}