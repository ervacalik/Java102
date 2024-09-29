
public class SafeHouse extends GameNormalLocation{
	 public SafeHouse(Player player) {
		super(player, "Güvenli Ev",1,"Burası sizin için güvenli bir bölge, düşman yoktur!");
		
	}

	private int id;
	


	@Override
	boolean onLocation() {
		System.out.println("Güvenli evdesiniz...");
		System.out.println("Canınız yenilendi !!!");
		this.getPlayer().setHealthy(this.getPlayer().getOriginalHaelth());
		return true;
	}
	

	

}
