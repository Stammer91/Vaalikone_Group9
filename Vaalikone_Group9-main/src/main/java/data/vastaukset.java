package data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class vastaukset implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	
	private String vastausSTR;
	
	private int vastaus;
	
	private ehdokkaat ehdokas;

	private kysymykset kysymys;
	
	public vastaukset() {
		
	}
	public vastaukset(String vastausSTR) {
		this.vastausSTR=vastausSTR;
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
	
	public ehdokkaat getEhdokas() {
		return this.ehdokas;
	}

	public void setEhdokas(ehdokkaat ehdokas) {
		this.ehdokas = ehdokas;
	}
	
	public kysymykset getKysymys() {
		return this.kysymys;
	}

	public void setKysymys(kysymykset kysymys) {
		this.kysymys = kysymys;
	}

}
