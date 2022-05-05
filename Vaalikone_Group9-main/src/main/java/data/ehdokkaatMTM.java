package data;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the candidates database table.
 * 
 */
@Entity
@Table(name = "ehdokkaat")
@NamedQuery(name = "Ehdokas.findAll", query = "SELECT e FROM Ehdokas e")
public class ehdokkaatMTM implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EHDOKAS_ID")
	private int ehdokas_id;

	private int ika;

	@Column(name = "AANESTYSNUMERO")
	private int aanestysnumero;

	private String info;

	@Column(name = "Etunimi")
	private String etunimi;

	private String kunta;

	private String puolue;

	private String ammatti;

	private String sukunimi;

	// bi-directional many-to-one association to Answer
	@OneToMany(mappedBy = "ehdokas")
	private List<vastauksetMTM> vastaus;

	public ehdokkaatMTM() {
	}

	public ehdokkaatMTM(String id, String sukunimi, String etunimi, String aanestysnumero, String ika, String kunta,
			String puolue, String ammatti, String info) {
		setId(id);
		this.sukunimi = sukunimi;
		this.etunimi = etunimi;
		setAanestysnumero(aanestysnumero);
		setIka(ika);
		this.kunta = kunta;
		this.puolue = puolue;
		this.ammatti = ammatti;
		this.info = info;
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
	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getEtunimi() {
		return this.etunimi;
	}

	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}

	public String getKunta() {
		return this.kunta;
	}

	public void setKunta(String kunta) {
		this.kunta = kunta;
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
		return this.vastaus;
	}

	public void setVastaus(List<vastauksetMTM> vastaus) {
		this.vastaus = vastaus;
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