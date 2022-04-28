package data;

/**
 * Date: 19.4 2022
 * This is a data handling for questions
 * @author Oskar
 *
 */
public class kysymykset {
	private int id;
	private String kysymys;
	
	public kysymykset() {
		
	}
	
	/**
	 * @param id
	 * @param kysymys
	 * To be used in app to get database info to placed in variables
	 */
	public kysymykset(int id, String kysymys) {
		
		setId(id);
		this.kysymys=kysymys;
	}

	/**
	 * Getter for id
	 * Returns int id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the declared variable id to int id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Changes the int id to String id
	 */
	public void setId(String id) {
		try {
			this.id = Integer.parseInt(id);
		}
		catch(NumberFormatException | NullPointerException e) {
		}
	}
	/**
	 * Getter for kysymys
	 */
	public String getKysymys() {
		return kysymys;
	}
	/**
	 * Sets the declared variable kysymys to String kysymys
	 */
	public void setKysymys(String kysymys) {
		this.kysymys = kysymys;
	}
}
