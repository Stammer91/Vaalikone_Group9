package data;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "ehdokkaat")
@NamedQuery(name = "ehdokkaatMTM.findAll", query = "SELECT e FROM ehdokkaatMTM e")
public class ehdokkaatMTM implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EHDOKAS_ID")
	private int ehdokas_id;

	private int ika;

	@Column(name = "AANESTYSNUMERO")
	private int aanestysnumero;

	@Column(name = "Etunimi")
	private String etunimi;

	private String kotipaikkakunta;

	private String puolue;

	private String ammatti;

	private String sukunimi;

	
	@OneToMany(mappedBy = "ehdokas")
	private List<vastauksetMTM> vastaukset;

	public ehdokkaatMTM() {
	}

	public ehdokkaatMTM(String id, String sukunimi, String etunimi, String aanestysnumero, String ika, String kotipaikkakunta,
			String puolue, String ammatti) {
		setId(id);
		this.sukunimi = sukunimi;
		this.etunimi = etunimi;
		setAanestysnumero(aanestysnumero);
		setIka(ika);
		this.kotipaikkakunta = kotipaikkakunta;
		this.puolue = puolue;
		this.ammatti = ammatti;
	}

	public int getEhdokas_Id() {
		return this.ehdokas_id;
	}

	public void setEhdokas_Id(int ehdokas_id) {
		this.ehdokas_id = ehdokas_id;
	}

	public void setId(String id) {
		try {
			this.ehdokas_id = Integer.parseInt(id);
		} catch (NumberFormatException | NullPointerException e) {

		}
	}

	public int getIka() {
		return this.ika;
	}

	public void setAge(int ika) {
		this.ika = ika;
	}
	public void setIka(String ika) {
		try {
			this.ika = Integer.parseInt(ika);
		} catch (NumberFormatException | NullPointerException e) {

		}
	}
	public int getAanestysnumero() {
		return this.aanestysnumero;
	}

	public void setAanestysnumero(int aanestysnumero) {
		this.aanestysnumero = aanestysnumero;
	}

	public void setAanestysnumero(String aanestysnumero) {
		try {
			this.aanestysnumero = Integer.parseInt(aanestysnumero);
		} catch (NumberFormatException | NullPointerException e) {

		}
	}
	
	public String getEtunimi() {
		return this.etunimi;
	}

	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}

	public String getKotipaikkakunta() {
		return this.kotipaikkakunta;
	}

	public void setKotipaikkakunta(String kotipaikkakunta) {
		this.kotipaikkakunta = kotipaikkakunta;
	}

	public String getPuolue() {
		return this.puolue;
	}

	public void setPuolue(String puolue) {
		this.puolue = puolue;
	}

	public String getAmmatti() {
		return this.ammatti;
	}

	public void setAmmatti(String ammatti) {
		this.ammatti = ammatti;
	}

	public String getSukunimi() {
		return this.sukunimi;
	}

	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}

	public List<vastauksetMTM> getVastaus() {
		return this.vastaukset;
	}

	public void setVastaus(List<vastauksetMTM> vastaukset) {
		this.vastaukset = vastaukset;
	}

	public vastauksetMTM addVastaus(vastauksetMTM vastaus) {
		getVastaus().add(vastaus);
		vastaus.setEhdokas(this);

		return vastaus;
	}

	public vastauksetMTM removeVastaus(vastauksetMTM vastaus) {
		getVastaus().remove(vastaus);
		vastaus.setEhdokas(null);

		return vastaus;
	}

	public String toString() {
		return "Ehdokas ID: "+this.ehdokas_id;
	}

}