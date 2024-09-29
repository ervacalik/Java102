import java.util.Scanner;

public class Player extends Invontery {

	Scanner scanner = new Scanner(System.in);
	public Invontery invontery;
	private int damage;
	private int healthy;
	private int money;
	private String name;
	private String charName;
	public int getOriginalHaelth() {
		return originalHaelth;
	}

	public void setOriginalHaelth(int originalHaelth) {
		this.originalHaelth = originalHaelth;
	}

	private int originalHaelth;

	// Oyun oynayan kişinin adını aldım.
	public Player(String name) {
		this.name = name;
		this.invontery = new Invontery();
	}

	public void selectChar() {
		System.out.println();
		System.out.println("##### Karakterler #####");
		GameCharacter[] charlist = { new Samurai(), new Archer(), new Knight() };
		System.out.println("-----------------------------------------------------------------");

		for (GameCharacter gameCharacter : charlist) {
			System.out.println("Karakter: " + gameCharacter.getName() + "    Id: " + gameCharacter.getId()
					+ "    Hasar: " + gameCharacter.getDamage() + "    Sağlık: " + gameCharacter.getHealthy()
					+ "    Para: " + gameCharacter.getMoney());
		}
		System.out.println("-----------------------------------------------------------------");
		System.out.print("Seçtiğiniz karakter(id):");
		int selectChar = scanner.nextInt();
		switch (selectChar) {
		case 1:
			initPlayer(new Samurai());
			break;
		case 2:
			initPlayer(new Archer());
			break;
		case 3:
			initPlayer(new Knight());
			break;
		default:
			initPlayer(new Samurai());
			break;
		}
		
		System.out.println("Silah: "+this.getWeapon().getName()+",  Zırh: "+ this.getArmor().getName() +",  Bloklama: "+this.getArmor().getBlocking()+",  Hasar: " + this.getDamage() + ",  Sağlık: "
				+ this.getHealthy() + ",  Para: " + this.getMoney());
		System.out.println("-----------------------------------------------------------------");
	}

	public void selectLocation() {

	}

	public void initPlayer(GameCharacter gameCharacter) {
		this.setDamage(gameCharacter.getDamage());
		this.setHealthy(gameCharacter.getHealthy());
		this.setOriginalHaelth(gameCharacter.getHealthy());
		this.setMoney(gameCharacter.getMoney());
		this.setName(gameCharacter.getName());

	}

	public void printInfo() {
		System.out.println("Silahınız: " + this.getWeapon().getName() + "  Zırhınız: " + this.getInvontery().getArmor().getName()
				+ "  Bloklama: "+this.getInvontery().getArmor().getBlocking()+"  Hasarınız: " + this.getDamage() + "  Sağlığınız: " + this.getHealthy() + "  Paranız: "
				+ this.getMoney());

	}

	public Invontery getInvontery() {
		return invontery;
	}

	public void setInvontery(Invontery invontery) {
		this.invontery = invontery;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealthy() {
		return healthy;
	}

	public void setHealthy(int healthy) {
		this.healthy = healthy;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCharName() {
		return charName;
	}

	public void setCharName(String charName) {
		this.charName = charName;
	}

}
