package design.pattern.state;

public class Light {

    protected LightState lightState;

    private LightState offState = new LightState() {
        @Override
        public void on() {
            System.out.println("Light ON");
            lightState = onState;
        }

        @Override
        public void off() {
            System.out.println("nothing");
        }
    };

    private LightState onState = new LightState() {
        @Override
        public void on() {
            System.out.println("nothing");
        }

        @Override
        public void off() {
            System.out.println("Light OFF");
            lightState = onState;
        }
    };

    public Light() {
        lightState = offState;
    }

    public void on() {
        lightState.on();
    }

    public void off() {
        lightState.off();
    }
}


interface LightState {

    void on();

    void off();
}