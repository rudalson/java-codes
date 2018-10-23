package design.pattern.strategy;

public class StrategyMain {

	public static void main(String[] args) {
		
		GameCharacter hero = new GameCharacter();
		hero.attack();
		
		hero.setWeapon(new Knife());
		hero.attack();
		
		hero.setWeapon(new Sword());
		hero.attack();
	}

}
