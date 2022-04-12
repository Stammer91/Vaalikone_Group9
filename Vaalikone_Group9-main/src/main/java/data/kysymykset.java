package data;

public class kysymykset {
	private int id;
	private String kysymys;
	
	public kysymykset() {
		
	}
	
	public kysymykset(int id, String kysymys) {
		
		setId(id);
		this.kysymys=kysymys;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setId(String id) {
		try {
			this.id = Integer.parseInt(id);
		}
		catch(NumberFormatException | NullPointerException e) {
		}
	}
	public String getKysymys() {
		return kysymys;
	}
	public void setKysymys(String kysymys) {
		this.kysymys = kysymys;
	}
}
