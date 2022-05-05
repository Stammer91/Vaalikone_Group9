package data;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the questions database table.
 * 
 */
@Entity
@Table(name="kysymykset")
@NamedQuery(name="Kysymys.findAll", query="SELECT k FROM kysymykset k")
public class kysymyksetMTM implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Kysymys_id")
	private int id;

	private String kysymys;

	//bi-directional many-to-one association to Answer
	@OneToMany(mappedBy="kysymys")
	private List<vastauksetMTM> vastaukset;
	
	public kysymyksetMTM() {
		
	}
	
	/**
	 * @param id
	 * @param kysymys
	 * To be used in app to get database info to placed in variables
	 */
	public kysymyksetMTM(int id, String kysymys) {
		
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
	
	public List<vastauksetMTM> getVastaus() {
		return this.vastaukset;
	}

	public void setVastaus(List<vastauksetMTM> vastaukset) {
		this.vastaukset = vastaukset;
	}
	
	public vastauksetMTM addVastaus(vastauksetMTM vastaus) {
		getVastaus().add(vastaus);
		vastaus.setKysymys(this);

		return vastaus;
	}

	public vastauksetMTM removeVastaus(vastauksetMTM vastaus) {
		getVastaus().remove(vastaus);
		vastaus.setKysymys(null);

		return vastaus;
	}

	public String toString() {
		return "Ehdokas ID: "+this.id;
	}

}
