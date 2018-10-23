package design.pattern.bridge;

import org.study.bridge.device.SoundMorseCodeFunction;

// 모오스 부호를 표현하는 장치를 생각해보자
public class BridgeMain {

    public static void main(String[] args) {

        PrintMorseCode code = new PrintMorseCode(new SoundMorseCodeFunction());

        code.g().a().r().a().m();
    }
}
