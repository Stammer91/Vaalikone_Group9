package data;

/**
 * Date: 19.4 2022
 * This is a data handling for canditates
 * @author Oskar
 *
 */
public class ehdokkaat {
	
	private int ehdokas_id;
	private String sukunimi;
	private String etunimi;
	private String puolue;
	private String kotipaikkakunta;
	private int ika;
	private String miksi_eduskuntaan;
	private String mita_asioita_haluat_edistaa;
	private String ammatti;
	private int aanestysnumero;
	

	public ehdokkaat() {
		
	}
	/**
	 * @param ehdokas_id
	 * @param sukunimi
	 * @param etunimi
	 * @param puolue
	 * @param kunta
	 * @param ika
	 * @param miksi
	 * @param mita
	 * @param ammatti
	 * @param aanestysnumero
	 * To be used in app to get database info to placed in variables
	 */
	public ehdokkaat(int ehdokas_id, String sukunimi, String etunimi, String puolue, String kunta, int ika, String miksi, String mita, String ammatti, int aanestysnumero) {
		
		setEhdokas_Id(ehdokas_id);
		this.sukunimi = sukunimi;
		this.etunimi = etunimi;
		this.puolue = puolue;
		this.kotipaikkakunta = kunta;
		setIka(ika);
		this.miksi_eduskuntaan = miksi;
		this.mita_asioita_haluat_edistaa = mita;
		this.ammatti = ammatti;
		setAanestysnumero(aanestysnumero);
		
	}
	/**
	 * Getter for ehdokas_id
	 * Returns int ehdokas_id
	 */
	public int getEhdokas_Id() {
		return ehdokas_id;
	}
	/**
	 * Sets the declared variable ehdokas_id to int ehdokas_id
	 */
	public void setEhdokas_Id(int ehdokas_id) {
		this.ehdokas_id = ehdokas_id;
	}
	/**
	 * Changes the int ehdokas_id to String ehokas_id
	 */
	public void setEhdokas_Id(String ehdokas_id) {
		try {
			this.ehdokas_id = Integer.parseInt(ehdokas_id);
		}
		catch(NumberFormatException | NullPointerException e) {
		}
	}
	/**
	 * Getter for sukunimi
	 * Returns String sukunimi
	 */
	public String getSukunimi() {
		return sukunimi;
	}
	/**
	 * Sets the declared variable sukunimi to String sukunimi
	 */
	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}
	/**
	 * Getter for etunimi
	 * Returns String etunimi
	 */
	public String getEtunimi() {
		return etunimi;
	}
	/**
	 * Sets the declared variable etunimi to String etunimi
	 */
	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}
	/**
	 * Getter for puolue
	 * Returns String puolue
	 */
	public String getPuolue() {
		return puolue;
	}
	/**
	 * Sets the declared variable puolue to String puolue
	 */
	public void setPuolue(String puolue) {
		this.puolue = puolue;
	}
	/**
	 * Getter for kotipaikkakunta
	 * Returns String kotipaikkakunta
	 */
	public String getKotipaikkakunta() {
		return kotipaikkakunta;
	}
	/**
	 * Sets the declared variable kotipaikkakunta to String kotipaikkakunta
	 */
	public void setKotipaikkakunta(String kotipaikkakunta) {
		this.kotipaikkakunta = kotipaikkakunta;
	}
	/**
	 * Getter for ika
	 * Returns int ika
	 */
	public int getIka() {
		return ika;
	}
	/**
	 * Sets the declared variable ika to int ika
	 */
	public void setIka(int ika) {
		this.ika = ika;
	}
	/**
	 * Changes the int ika to String ika
	 */
	public void setIka(String ika) {
		try {
			this.ika = Integer.parseInt(ika);
		}
		catch(NumberFormatException | NullPointerException e) {
		}
	}
	/**
	 * Getter for miksi_eduskuntaan
	 * Returns String miksi_eduskuntaan
	 */
	public String getMiksi_eduskuntaan() {
		return miksi_eduskuntaan;
	}
	/**
	 * Sets the declared variable miksi_eduskuntaan to String miksi_eduskuntaan
	 */
	public void setMiksi_eduskuntaan(String miksi_eduskuntaan) {
		this.miksi_eduskuntaan = miksi_eduskuntaan;
	}
	/**
	 * Getter for mita_asioita_haluat_edistaa
	 * Returns String mita_asioita_haluat_edistaa
	 */
	public String getMita_asioita_haluat_edistaa() {
		return mita_asioita_haluat_edistaa;
	}
	/**
	 * Sets the declared variable mita_asioita_haluat_edistaa to String mita_asioita_haluat_edistaa
	 */
	public void setMita_asioita_haluat_edistaa(String mita_asioita_haluat_edistaa) {
		this.mita_asioita_haluat_edistaa = mita_asioita_haluat_edistaa;
	}
	/**
	 * Getter for ammatti
	 * Returns String ammatti
	 */
	public String getAmmatti() {
		return ammatti;
	}
	/**
	 * Sets the declared variable ammatti to String ammatti
	 */
	public void setAmmatti(String ammatti) {
		this.ammatti = ammatti;
	}
	/**
	 * Getter for aanestysnumero
	 * Returns int aanestysnumero
	 */
	public int getAanestysnumero() {
		return aanestysnumero;
	}
	/**
	 * Sets the declared variable aanestysnumero to int aanestysnumero
	 */
	public void setAanestysnumero(int aanestysnumero) {
		this.aanestysnumero = aanestysnumero;
	}
	/**
	 * Changes the int aanestysnumero to String aanestysnumero
	 */
	public void setAanestysnumero(String aanestysnumero) {
		try {
			this.aanestysnumero = Integer.parseInt(aanestysnumero);
		}
		catch(NumberFormatException | NullPointerException e) {
		}
	}
}
