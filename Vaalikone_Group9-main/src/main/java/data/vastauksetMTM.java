package data;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the answers database table.
 * 
 */
@Entity
@Table(name="vastaukset")
@NamedQuery(name="Vastaus.findAll", query="SELECT v FROM vastaukset v")
public class vastauksetMTM implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	
	private int vastaus;

	//bi-directional many-to-one association to Candidate
	@ManyToOne
	@JoinColumn(name="EHDOKAS_ID")
	private ehdokkaatMTM ehdokas;

	//bi-directional many-to-one association to Question
	@ManyToOne
	@JoinColumn(name="KYSYMYS_ID")
	private kysymyksetMTM kysymys;

	
	public vastauksetMTM() {
		
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getVastaus() {
		return this.vastaus;
	}

	public void setVastaus(int vastaus) {
		this.vastaus = vastaus;
	}
	
	public ehdokkaatMTM getEhdokas() {
		return this.ehdokas;
	}

	public void setEhdokas(ehdokkaatMTM ehdokkaatMTM) {
		this.ehdokas = ehdokkaatMTM;
	}
	
	public kysymyksetMTM getKysymys() {
		return this.kysymys;
	}

	public void setKysymys(kysymyksetMTM kysymyksetMTM) {
		this.kysymys = kysymyksetMTM;
	}
	
	public String toString() {
		return "Vastaus: "+this.id+"/"+this.vastaus;
	}

}
