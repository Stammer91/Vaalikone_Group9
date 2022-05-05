package data;

import java.io.Serializable;
import javax.persistence.*;



@Entity
@Table(name="vastaukset")
@NamedQuery(name="vastauksetMTM.findAll", query="SELECT v FROM vastauksetMTM v")
public class vastauksetMTM implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	
	private int vastaus;


	@ManyToOne
	@JoinColumn(name="EHDOKAS_ID")
	private ehdokkaatMTM ehdokas;

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

	public void setEhdokas(ehdokkaatMTM ehdokas) {
		this.ehdokas = ehdokas;
	}
	
	public kysymyksetMTM getKysymys() {
		return this.kysymys;
	}

	public void setKysymys(kysymyksetMTM kysymys) {
		this.kysymys = kysymys;
	}
	
	public String toString() {
		return "Vastaus: "+this.id+"/"+this.vastaus;
	}

}
