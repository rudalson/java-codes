package design.pattern.builder;

public class Computer {

    private final String cpu;
    private final String ram;
    private final String storage;

    public static class builder {

        public builder() {}

        private String cpu;
        private String ram;
        private String storage;

        public builder cpu(String c) {
            cpu = c;
            return this;
        }

        public builder ram(String r) {
            ram = r;
            return this;
        }

        public builder storage(String s) {
            storage = s;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    private Computer(builder builder) {
        cpu = builder.cpu;
        ram = builder.ram;
        storage = builder.storage;
    }

    public String getCpu() {
        return cpu;
    }

    public String getRam() {
        return ram;
    }

    public String getStorage() {
        return storage;
    }

    @Override
    public String toString() {
        return getCpu() + "-" + getRam() + "-" + getStorage();
    }
}
