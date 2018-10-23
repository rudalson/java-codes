package design.pattern.builder;

public class ComputerMain {
    public static void main(String[] args) {

        Computer com1 = new Computer.builder().cpu("i7").ram("16g").storage("ssd").build();
        System.out.println(com1.getCpu());

        Computer com2 = new Computer.builder().cpu("i5").ram("8g").storage("ssd").build();
        System.out.println(com2.getCpu() + " - " + com2.getRam());
    }
}
