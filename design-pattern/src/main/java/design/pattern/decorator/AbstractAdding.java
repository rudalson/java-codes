package design.pattern.decorator;

abstract public class AbstractAdding implements IBeverage {

    private IBeverage base;

    public AbstractAdding(IBeverage base) {
        super();
        this.base = base;
    }

    @Override
    public int getTotalPrice() {
        return base.getTotalPrice();
    }

    protected IBeverage getBase() {
        return base;
    }
}
