package design.pattern.strategy;

public class GameCharacter {
	
	private Weapon weapon;
	
	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public void attack() {
		
		if (weapon == null) {
			System.out.println("no weapon");
			return;
		}
		
		// delegate
		weapon.attack();
	}
}
