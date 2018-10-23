package design.pattern.decorator;

public class Milk extends AbstractAdding {

    public Milk(IBeverage base) {
        super(base);
    }

    @Override
    public int getTotalPrice() {
        return super.getTotalPrice() + 50;
    }
}
