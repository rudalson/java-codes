package design.pattern.chainofresponsibility2;

public class Armor implements Defense {

    private Defense nextDefense;
    private int def;

    public Armor(int def) {
        this.def = def;
    }

    @Override
    public void defense(Attack attack) {

        process(attack);

        if (nextDefense!= null) {
            nextDefense.defense(attack);
        }
    }

    private void process(Attack attack) {
        int amount = attack.getAmount();
        amount -= def;
        attack.setAmount(amount);
    }

    public void setNextDefense(Defense next) {
        nextDefense = next;
    }
}
