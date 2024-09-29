
public class Armor {
	private int id;
	private String name;
	private int blocking;
	private int price;
	
	public Armor(String name, int id, int blocking, int price) {
		this.name=name;
		this.id=id;
		this.blocking=blocking;
		this.price=price;
	}
	public Armor(String name ,int blocking) {
		this.name=name;
		
		this.blocking=blocking;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBlocking() {
		return blocking;
	}

	public void setBlocking(int blocking) {
		this.blocking = blocking;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	

}
