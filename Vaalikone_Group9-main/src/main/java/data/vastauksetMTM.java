package data;

import java.io.Serializable;
import javax.persistence.*;



@Entity
@Table(name="vastaukset")
@NamedQuery(name="Vastaukset.findAll", query="SELECT v FROM Vastaukset v")
public class vastauksetMTM implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	
	private int vastaukset;


	@ManyToOne
	@JoinColumn(name="EHDOKAS_ID")
	private ehdokkaatMTM ehdokkaat;

	@ManyToOne
	@JoinColumn(name="KYSYMYS_ID")
	private kysymyksetMTM kysymykset;

	
	public vastauksetMTM() {
		
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getVastaus() {
		return this.vastaukset;
	}

	public void setVastaus(int vastaus) {
		this.vastaukset = vastaus;
	}
	
	public ehdokkaatMTM getEhdokas() {
		return this.ehdokkaat;
	}

	public void setEhdokas(ehdokkaatMTM ehdokkaatMTM) {
		this.ehdokkaat = ehdokkaatMTM;
	}
	
	public kysymyksetMTM getKysymys() {
		return this.kysymykset;
	}

	public void setKysymys(kysymyksetMTM kysymyksetMTM) {
		this.kysymykset = kysymyksetMTM;
	}
	
	public String toString() {
		return "Vastaus: "+this.id+"/"+this.vastaukset;
	}

}
