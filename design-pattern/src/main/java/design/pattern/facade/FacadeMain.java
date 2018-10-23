package design.pattern.facade;

import design.pattern.facade.system.Facade;

public class FacadeMain {

    public static void main(String[] args) {

        Facade facade = new Facade();

        facade.process();
    }
}
