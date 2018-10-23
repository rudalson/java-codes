package design.pattern.abstractfactory;

import org.study.abstractfactory.concrete.FactoryInstance;

public class AbstractFactoryMain {

    public static void main(String[] args) {

        GuiFactory factory = FactoryInstance.getGuiFactory(System.getProperty("os.name"));

        Button button = factory.createButton();
        TextArea area = factory.createTextArea();

        button.click();
        System.out.println(area.getText());
    }
}
