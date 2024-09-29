
public abstract class GameNormalLocation extends GameLocation{

	
	
	public GameNormalLocation(Player player, String name, int id,String locInfo) {
		super(player, name, id, locInfo);
		
	}

	@Override
	boolean onLocation() {

		return true;
	}
	

}
