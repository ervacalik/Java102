
public class Invontery {
	private boolean water = false;
	private boolean food = false;
	private boolean fireword = false;

	private Armor armor;

	private Weapon weapon;

	public Invontery() {
		this.weapon = new Weapon("Yumruk", -1, 0, 0);
		this.armor = new Armor("Paçavra", -1, 0, 0);
		

	}

	public Armor getArmor() {
		return armor;
	}

	public void setArmor(Armor armor) {
		this.armor = armor;
	}

	public boolean isWater() {
		return water;
	}

	public void setWater(boolean water) {
		this.water = water;
	}

	public boolean isFood() {
		return food;
	}

	public void setFood(boolean food) {
		this.food = food;
	}

	public boolean isFireword() {
		return fireword;
	}

	public void setFireword(boolean fireword) {
		this.fireword = fireword;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public void setArmor(int blocking) {
		// TODO Auto-generated method stub
		
	}

}
