
public class Weapon {
	private int id;
	private int damage;
	private int money;
	private String name;
	
	public Weapon(String name,int id, int damage, int money) {
		this.name=name;
		this.id=id;
		this.damage=damage;
		this.money=money;
		
	}
	public Weapon(String name, int damage) {
		this.name=name;
		
		this.damage=damage;
		
		
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	

}
