import java.util.Scanner;

public class ToolStore extends GameNormalLocation {
	private int id;
	private Weapon weapon;

	public ToolStore(Player p) {
		super(p,"Mağaza",2,"Silah veya Zırh satın alabilirsiniz !");
		
		
	}
	Scanner scanner =new Scanner(System.in);
	
	@Override
	boolean onLocation() {
		
		System.out.println("Mağazaya hoşgeldiniz :)");
		System.out.println("Mağazadaki katogoriler: ");
		System.out.println("1-Silah");
		System.out.println("2-Zırh");
		System.out.println("3-Çıkış yap");
		System.out.print("Hangi katagoriye girmek istersiniz: ");
		int select= scanner.nextInt();
		while (select<1 || select>3) {
			System.out.println("Geçersiz bir sayı girdiniz. Lütfen tekrar deneyin!!!");
			select =scanner.nextInt();
		}
		System.out.println("--------------------------------------------------");
		switch (select) {
		case 1:
			System.out.println("Silah katagorisine yönlendiriliyorsunuz...");
			System.out.println();
			System.out.println("##### Silahlar #####");
			Weapon[] weaponList= {new Gun(), new Sword(),new Rifle()};
			for (Weapon weapon : weaponList) {
				System.out.println("Silah: "+weapon.getName()+"  Id: "+ weapon.getId()+"   Hasar: "+weapon.getDamage()+ "  Ücret: "+weapon.getMoney());
			}
			System.out.println("---------------------------------------------------");
			System.out.println("0 - Çıkış yap");
			System.out.print("Almak istediğiniz silahı seçin veya çıkış yapın:  ");
			int selectWeapon=scanner.nextInt();
			while (selectWeapon<0 || selectWeapon>3) {
				System.out.println("Geçersiz bir sayı girdiniz. Lütfen tekrar deneyin!!!");
				selectWeapon =scanner.nextInt();
			}
			if (selectWeapon ==0) {
				System.out.println("Bölgeler sayfasına yönlendiriliyorsunuz...");
				break;
			}
			switch (selectWeapon) {
			case 1:
				buyWeapon(getPlayer(), weaponList[0]);
				break;
			case 2:
				buyWeapon(getPlayer(), weaponList[1]);
				break;
			case 3:
				buyWeapon(getPlayer(), weaponList[2]);
				break;
			default:
				System.out.println("Hiçbir silah alamadınız. Tekrar deneyin. ");
				break;
			}
			
			
			break;
			
		case 2:
			System.out.println("Zırh katagorisine yönlendiriliyorsunuz...");
			System.out.println();
			System.out.println("##### Zırhlar #####");
			Armor[] armorList= {new LightArmor(),new MiddleArmor(),new HeavyArmor()};
			for (Armor armor : armorList) {
				System.out.println("Zırh: "+ armor.getName()+"   Id: "+armor.getId()+"   Engelleme: "+ armor.getBlocking()+"   Ücret: "+armor.getPrice());
				
			}
			System.out.println("0 - Çıkış yap");
			System.out.print("Almak istediğiniz zırhı seçin veya çıkış yapın:  " );
			int selectArmor=scanner.nextInt();
			while (selectArmor<0 || selectArmor>3) {
				System.out.print("Geçersiz bir sayı girdiniz. Lütfen tekrar deneyin! : ");
				selectWeapon =scanner.nextInt();
			}
			if (selectArmor ==0) {
				System.out.println("Bölgeler sayfasına yönlendiriliyorsunuz...");
				break;
			}
			switch (selectArmor) {
			case 1:
				
				buyArmor(getPlayer(), armorList[0]);
				getPlayer().printInfo();
				break;
			case 2:
				buyArmor(getPlayer(), armorList[1]);
				break;
			case 3: 
				buyArmor(getPlayer(), armorList[2]);
				break;
			default:
				System.out.println("Hiçbir zırh almadınız. Tekrar deneyin");
				break;
			}
			break;
			
		case 3:
			
			System.out.println("Bir daha bekleriz :)");
			break;
			

		default:
			System.out.println("Bir daha bekleriz");
			break;
		}
		
		
		

		return true;
	}
	

	
	
	public void buyWeapon(Player player,Weapon weapon) {
		System.out.println("Satın alma işlemi gerçekleştiriliyor");
		int playerMoney= player.getMoney();
		int weaponMoney = weapon.getMoney();
		
		if (playerMoney>= weaponMoney) {
			player.setMoney(playerMoney-weaponMoney);
			System.out.println(weapon.getName()+" satın aldınız.");
			System.out.println("Kalan paranız: "+ player.getMoney());
			System.out.println("Önceki silahınız: "+ this.getPlayer().getInvontery().getWeapon().getName());
			this.getPlayer().getInvontery().setWeapon(weapon);
			System.out.println("Sonraki silahınız: "+ this.getPlayer().getInvontery().getWeapon().getName());
			System.out.println("Önceki hasarınız: "+this.getPlayer().getDamage());
			int charDamage= this.getPlayer().getDamage();
			this.getPlayer().setDamage(weapon.getDamage()+charDamage);
			
			System.out.println("Sonraki hasarınız: "+ this.getPlayer().getDamage());
		}
		else {
			System.out.println("Yeterli miktarda paranız yok.");
		}
		
	}
	
	
	public void buyArmor(Player player,Armor armor) {
		System.out.println("Satın alma işlemi gerçekleştiriliyor");
		int playerMoney= player.getMoney();
		int armorMoney = armor.getPrice();
		
		if (playerMoney>=armorMoney) {
			player.setMoney(playerMoney-armorMoney);
			System.out.println(armor.getName()+" bir zırhsatın aldınız.");
			System.out.println("Kalan paranız: "+ player.getMoney());
			System.out.println("Önceki zırhınız: "+this.getPlayer().getArmor().getName());
			this.getPlayer().getInvontery().setArmor(armor);
			System.out.println("Şu anki zırhınız: " + this.getPlayer().getInvontery().getArmor().getName());
			int selectedArmorDamage=armor.getBlocking();
			this.getPlayer().getInvontery().setArmor(armor.getBlocking());;
			
		}
		else {
			System.out.println("Yeterli miktarda paranız yok.");
		}
		
	}
	
	
	
	


}
