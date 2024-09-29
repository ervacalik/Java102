
import java.util.Scanner;

public class Game {

	Scanner scanner = new Scanner(System.in);

	public void start() {
		System.out.println("Macera Oyununa Hoşgeldiniz !!!");
		System.out.print("Lütfen isminizi giriniz:");
		// String playerName= scanner.nextLine();
		System.out.println();
		Player player1 = new Player("Erva");
		System.out.println(
				player1.getName() + " bu karanlık ve sisli adaya hoşgeldin... Burada yaşananların hepsi gerçek!");
		System.out.println("Lütfen bir karakter seç !!! ");
		player1.selectChar();
		GameLocation location = null;

		while (true) {
			System.out.println();
			if (player1.getInvontery().isFireword() && player1.getInvontery().isFood() && player1.getInvontery().isWater()) {
				System.out.println("...........Tebrikler oyunu kazandınız...........");
				break;
			}
			System.out.println("###### Bölgeler #####");
			System.out.println();
			GameLocation[] locList = { new SafeHouse(player1), new ToolStore(player1),
					new Cave(player1), new Forest(player1), new River(player1),new Coal(player1) };
			System.out.println("0 Çıkış Yap --> Oyundan çıkış yapabilirsiniz");
			for (GameLocation gameLocation : locList) {
				System.out.println(
						gameLocation.getId() + " " + gameLocation.getName() + "  -->   " + gameLocation.getLocInfo());
			}
			System.out.println("-----------------------------------------------------------------");
			System.out.print("Seçtiğiniz bölge(id): ");
			int selectLoc = scanner.nextInt();
			System.out.println("-----------------------------------------------------------------");

			while (selectLoc < 0 || selectLoc > 6) {
				System.out.print("Lütfen 0 ve 6 srasında bir değer girin: ");
				selectLoc = scanner.nextInt();
			}
			if (selectLoc ==0) {
				System.out.println("Bu karanlık  ve sisli adadan çabuk vazgeçtiniz :(");
				break;
			}
			switch (selectLoc) {
			case 1:
				
				location = new SafeHouse(player1);
				
				break;
				
			case 2:

				location = new ToolStore(player1);
				break;
				
			case 3:
				if (player1.getInvontery().isFood()) {
					System.out.println("Buradaki ödülü zaten topladınız.");
					break;
				}else {
					location = new Cave(player1);
				}
				
				
				break;
				
			case 4:
				if (player1.getInvontery().isFireword()) {
					System.out.println("Buradaki ödülü zaten topladınız.");
					break;
				}else {
					location = new Forest(player1);
				}
				
				break;
				
			case 5:
				
				if (player1.getInvontery().isWater()) {
		            System.out.println("Buradaki ödülü zaten topladınız.");
		            break;
		        } else {
		            location = new River(player1);
		        }
		        break;
			case 6:
				location =new Coal(player1);
				
			default:
				System.out.println("Lütfen geçerli bir bölge giriniz !");
				break;
			}

			if (!location.onLocation() ) {
				System.out.println("GAME OVER");
				break;
			}

		}

	}

}
