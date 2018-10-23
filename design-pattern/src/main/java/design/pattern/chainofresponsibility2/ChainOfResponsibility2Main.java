package design.pattern.chainofresponsibility2;

public class ChainOfResponsibility2Main {

    public static void main(String[] args) {

        Attack attack = new Attack(100);

        Armor armor1 = new Armor(10);
        Armor armor2 = new Armor(15);

        armor1.setNextDefense(armor2);

        armor1.defense(attack);

        System.out.println(attack.getAmount());

        Defense shield = new Defense() {

            @Override
            public void defense(Attack attack) {
                int amount = attack.getAmount();
                attack.setAmount(amount -= 50);
            }
        };

        armor2.setNextDefense(shield);

        attack.setAmount(100);
        armor1.defense(attack);
        System.out.println(attack.getAmount());

    }
}
