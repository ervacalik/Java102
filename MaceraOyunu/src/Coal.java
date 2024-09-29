import java.util.Random;

public class Coal extends GameBottleLocation {

	public Coal(Player player) {
		super(player, "Maden", 6, "Ödül: <Herhangi bir eşya >, dikkatli ol karşına yılan çıkabilir !", new Snake(),
				null, 5);

	}

	@Override
	boolean onLocation() {
		return super.onLocation();
	}

	public boolean combat(int obstacleNumber) {
		boolean isCombatSuccessful = super.combat(obstacleNumber);

		if (isCombatSuccessful) {
			for (int i = 0; i < obstacleNumber; i++) {
				dropLoot();
			}
		}

		return isCombatSuccessful;
	}

	private void dropLoot() {
		Random random = new Random();
		int lootChance = random.nextInt(100) + 1; // 0 ile 99 arasında rastgele sayı üret

		if (lootChance <= 15) { // 15% Silah kazanma ihtimali
			System.out.println("Silah kazandınız!");
			int whichWeapon = random.nextInt(100) + 1;
			// Silah ekleme işlemi
			if (whichWeapon <= 20) { // 20% Tüfek kazanma ihtimali
				System.out.println("Tüfek kazandınız!");
				Weapon rifle = new Weapon("Tüfek", 7);
				this.getPlayer().getInvontery().setWeapon(rifle);
				System.out.println("Yeni silahınız: " + rifle.getName() + "  Hasarınız: " + rifle.getDamage());

			} else if (whichWeapon > 20 && whichWeapon <= 50) { // 30% Kılıç kazanma ihtimali
				System.out.println("Kılıç kazandınız!");
				Weapon sword = new Weapon("Kılıç", 3);
				this.getPlayer().getInvontery().setWeapon(sword);
				System.out.println("Yeni silahınız: " + sword.getName() + "  Hasarınız: " + sword.getDamage());

			} else { // 50% Tabanca kazanma ihtimali
				System.out.println("Tabanca kazandınız!");
				Weapon gun = new Weapon("Tabanca", 2);
				this.getPlayer().getInvontery().setWeapon(gun);
				System.out.println("Yeni silahınız: " + gun.getName() + "  Hasarınız: " + gun.getDamage());

			}
		}

		else if (lootChance > 15 && lootChance <= 30) {
			System.out.println("Zırh kazandınız!");
			int whichArmor = random.nextInt(100) + 1;
			// Zırh ekleme işlemi
			if (whichArmor <= 20) {
				System.out.println("Ağır Zırh kazandınız!");
				Armor agir = new Armor("Ağır zırh", 5);
				this.getPlayer().getInvontery().setArmor(agir);
				System.out.println("Yeni zırhınız: " + agir.getName() + "  Bloklama: " + this.getPlayer().getDamage());
			} else if (whichArmor > 20 && whichArmor <= 50) {

				System.out.println("Orta Zırh kazandınız!");
				Armor ortArmor = new Armor("Orta zırh", 3);
				this.getPlayer().getInvontery().setArmor(ortArmor);
				System.out.println(
						"Yeni zırhınız: " + ortArmor.getName() + "  Bloklama: " + this.getPlayer().getDamage());

			} else { // 50% Hafif Zırh kazanma ihtimali
				System.out.println("Hafif Zırh kazandınız!");
				Armor hafifArmor = new Armor("Hafif zırh", 1);
				this.getPlayer().getInvontery().setArmor(hafifArmor);
				System.out.println(
						"Yeni zırhınız: " + hafifArmor.getName() + "  Bloklama: " + this.getPlayer().getDamage());

			}
		} else if (lootChance > 30 && lootChance <= 55) {
			int moneyChance = random.nextInt(100);
			if (moneyChance <= 20) {
				System.out.println("10 para kazandınız!");
				this.getPlayer().setMoney(this.getPlayer().getMoney() + 10);
			} else if (moneyChance > 20 && moneyChance < 50) {
				System.out.println("5 para kazandınız!");
				this.getPlayer().setMoney(this.getPlayer().getMoney() + 5);
			} else {
				System.out.println("1 para kazandınız!");
				this.getPlayer().setMoney(this.getPlayer().getMoney() + 1);
			}
		}

		else {
			System.out.println("Hiçbir şey kazanamadınız.");
		}
	}

}
