
public abstract class GameLocation {
	
	private String name;
	private Player player;
	private int id;
	private String locInfo;

	public GameLocation(Player player,String name, int id,String locInfo) {
		this.player =player;
		this.name=name;
		this.id=id;
		this.locInfo=locInfo;
		


	}
	public String getLocInfo() {
		return locInfo;
	}
	public void setLocInfo(String locInfo) {
		this.locInfo = locInfo;
	}
	abstract boolean onLocation() ;



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}




}
