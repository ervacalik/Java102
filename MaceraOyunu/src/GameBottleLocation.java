import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public abstract class GameBottleLocation extends GameLocation {

	Scanner scanner = new Scanner(System.in);
	private Obstacle obstacle;
	private String award;
	private int maxObstacle;

	public GameBottleLocation(Player player, String name, int id, String locInfo, Obstacle obstacle, String award,
			int maxObstacle) {
		super(player, name, id, locInfo);
		this.obstacle = obstacle;
		this.award = award;
		this.maxObstacle = maxObstacle;
	}

	@Override
	boolean onLocation() {
		if ((this.getName().equals("Mağara") && this.getPlayer().getInvontery().isFood())
				|| (this.getName().equals("Orman") && this.getPlayer().getInvontery().isFireword())
				|| (this.getName().equals("Nehir") && this.getPlayer().getInvontery().isWater())) {
			System.out.println("Buradaki ödülü zaten topladınız. Başka bir bölgeye gitmelisiniz.");
			return true;
		}
		
		
		
		
		
		
		int obstacleNumber = rondomObsNumber();
		System.out.println("Şu anda buradasınız: " + this.getName());
		System.out.println("Dikkatli ol. Burada: " + this.getObstacle().getName().toLowerCase() + " yaşıyor.");
		System.out.println(
				"Karşınıza çıkacak " + this.getObstacle().getName().toLowerCase() + " sayısı: " + obstacleNumber);
		System.out.print("<S>avaş veya <K>aç : ");
		String selecetCase = scanner.nextLine();
		selecetCase = selecetCase.toUpperCase();
		System.out.println("-----------------------------------------------");
		if (selecetCase.equals("S") && combat(obstacleNumber)) {
			System.out.println(this.getName() + " tüm düşmanları yendiniz.");
			if (this.getName().equals("Mağara")) {
				this.getPlayer().getInvontery().setFood(true);
				System.out.println("Mağaradan yemek topladınız:" + this.getPlayer().getInvontery().isFood());

			} else if (this.getName().equals("Orman")) {
				this.getPlayer().getInvontery().setFireword(true);
				System.out.println("Ormandan odun topladınız: " + this.getPlayer().getInvontery().isFireword());

			} else if (this.getName().equals("Nehir")) {
				this.getPlayer().getInvontery().setWater(true);
				System.out.println("Nehirden su topladınız: " + this.getPlayer().getInvontery().isWater());
			}

			return true;
		}

		if (this.getPlayer().getHealthy() <= 0) {
			System.out.println("Öldünüz");
			return false;

		}
		return true;
	}

	public boolean combat(int obstacleNumber) {
		int returnHealt = this.getObstacle().getHealth();
		for (int i = 1; i <= obstacleNumber; i++) {
			this.getObstacle().setHealth(returnHealt);
			playerStats();
			obstacleStats();
			while (this.getPlayer().getHealthy() > 0 && this.getObstacle().getHealth() > 0) {
				System.out.print("<V>ur veya <K>aç: ");
				String select = scanner.nextLine();
				select = select.toUpperCase();
				if (select.equals("V")) {

					Random random = new Random();
					int whostart = random.nextInt(2);
					if (whostart == 0) {
						System.out.println(this.getPlayer().getName() + " vurdu.");
						this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getDamage());
						afterHit();
						if (this.getObstacle().getHealth() > 0) {
							System.out.println(i + ". canavar size vurdu.");
							int obstacleDamage = this.getObstacle().getDamage()
									- this.getPlayer().getInvontery().getArmor().getBlocking();
							if (obstacleDamage < 0) {
								obstacleDamage = 0;

							}
							this.getPlayer().setHealthy(this.getPlayer().getHealthy() - obstacleDamage);
							afterHit();

						}

					} else if (whostart == 1) {
						if (this.getObstacle().getHealth() > 0) {
							System.out.println(i + ". canavar size vurdu.");
							int obstacleDamage = this.getObstacle().getDamage()
									- this.getPlayer().getInvontery().getArmor().getBlocking();
							if (obstacleDamage < 0) {
								obstacleDamage = 0;

							}
							this.getPlayer().setHealthy(this.getPlayer().getHealthy() - obstacleDamage);
							afterHit();

						}
						System.out.println("Siz vurdunuz...");
						this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getDamage());
						afterHit();

					}

				} else {
					return false;
				}
			}
			if (this.getObstacle().getHealth() < this.getPlayer().getHealthy()) {
				System.out.println(i + ". canavarla savaşma sonucunda: ");
				System.out.println("Düşmanı yendınız");
				this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getMoney());
			} else {
				return false;
			}

			System.out.println("//////////////////////////////////////////////");
		}

		return true;
	}

	public void afterHit() {
		System.out.println("Sağlık: " + this.getPlayer().getHealthy());
		System.out.println(this.getObstacle().getName() + " canı: " + this.getObstacle().getHealth());
		System.out.println();
	}

	public void playerStats() {
		System.out.println("Oyuncu Değerleri");
		System.out.println();
		System.out.println("Karakter: " + this.getPlayer().getName());
		System.out.println("Silah: " + this.getPlayer().getInvontery().getWeapon().getName());
		System.out.println("Zırh: " + this.getPlayer().getInvontery().getArmor().getName());
		System.out.println("Hasar: " + this.getPlayer().getDamage());
		System.out.println("Bloklama: " + this.getPlayer().getInvontery().getArmor().getBlocking());
		System.out.println("Sağlık: " + this.getPlayer().getHealthy());
		System.out.println("Para: " + this.getPlayer().getMoney());
		System.out.println();
	}

	public void obstacleStats() {
		System.out.println("Canavar Değerleri");
		System.out.println();
		System.out.println("Canavar: " + this.getObstacle().getName());
		System.out.println("Hasar: " + this.getObstacle().getDamage());
		System.out.println("Sağlık: " + this.getObstacle().getHealth());
		System.out.println("Para: " + this.getObstacle().getMoney());
		System.out.println();

	}

	public int rondomObsNumber() {
		Random random = new Random();
		return random.nextInt(this.getMaxObstacle()) + 1;
	}

	public int getMaxObstacle() {
		return maxObstacle;
	}

	public void setMaxObstacle(int maxObstacle) {
		this.maxObstacle = maxObstacle;
	}

	public Obstacle getObstacle() {
		return obstacle;
	}

	public void setObstacle(Obstacle obstacle) {
		this.obstacle = obstacle;
	}

	public String getAward() {
		return award;
	}

	public void setAward(String award) {
		this.award = award;
	}

}
