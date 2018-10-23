package design.pattern.bridge.device;

import org.study.bridge.MorseCodeFunction;

public class DefaultMorseCodeFunction implements MorseCodeFunction {
    @Override
    public void dot() {
        System.out.print(".");
    }

    @Override
    public void dash() {
        System.out.print("-");
    }

    @Override
    public void space() {
        System.out.print(" ");
    }
}
