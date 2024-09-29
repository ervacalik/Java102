
public abstract class GameCharacter {
	private int id;
	private String name;
	private int damage;
	private int healthy;
	private int money;

	public GameCharacter(String name, int damage, int healthy, int money, int id) {
		this.name = name;
		this.damage = damage;
		this.healthy = healthy;
		this.money = money;
		this.id = id;

	}

	public int getId() {
		return id;
	}

	public String getName() {
		return this.name;
	}

	public int getDamage() {
		return this.damage;

	}

	public int getHealthy() {
		return this.healthy;
	}

	public int getMoney() {
		return this.money;	}

}
