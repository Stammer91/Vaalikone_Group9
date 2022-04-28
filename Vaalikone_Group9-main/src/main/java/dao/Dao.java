package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.ehdokkaat;
import data.kysymykset;

import java.sql.Connection;

/**
 * Date: 14.4 2022
 * This is a class for sending sql commands to database
 * @author Oskari
 *
 */
public class Dao {
	private String url;
	private String user;
	private String pass;
	private Connection conn;
	
	public Dao(String url, String user, String pass) {
		this.url=url;
		this.user=user;
		this.pass=pass;
	}
	
	/**
	 * Connection to sql database, returns true if successful
	 */
	public boolean getConnection() {
		try {
	        if (conn == null || conn.isClosed()) {
	            try {
	                Class.forName("com.mysql.jdbc.Driver").newInstance();
	            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
	                throw new SQLException(e);
	            }
	            conn = DriverManager.getConnection(url, user, pass);
	        }
	        return true;
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	/**
	 * Executes query to sql that selects all canditates tables info from vaalikone database and places them to a list
	 * Returns a list
	 */
	public ArrayList<ehdokkaat> readAllEhdokkaat() {
		ArrayList<ehdokkaat> list=new ArrayList<>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet RS=stmt.executeQuery("select * from ehdokkaat");
			while (RS.next()){
				ehdokkaat ehdokas=new ehdokkaat();
				ehdokas.setEhdokas_Id(RS.getInt("ehdokas_id"));
				ehdokas.setSukunimi(RS.getString("sukunimi"));
				ehdokas.setEtunimi(RS.getString("etunimi"));
				ehdokas.setPuolue(RS.getString("puolue"));
				ehdokas.setKotipaikkakunta(RS.getString("kotipaikkakunta"));
				ehdokas.setIka(RS.getInt("ika"));
				ehdokas.setMiksi_eduskuntaan(RS.getString("miksi_eduskuntaan"));
				ehdokas.setMita_asioita_haluat_edistaa(RS.getString("mita_asioita_haluat_edistaa"));
				ehdokas.setAmmatti(RS.getString("ammatti"));
				ehdokas.setAanestysnumero(RS.getInt("aanestysnumero"));
				list.add(ehdokas);
			}
			return list;
		}
		catch(SQLException e) {
			return null;
		}
	}
	/**
	 * Executes query to sql that inserts html element variables to canditates table in vaalikone database
	 * Returns to readAllEhdokkaat
	 */
	public ArrayList<ehdokkaat> addEhdokkaat(ehdokkaat E) {
		String sql = "INSERT INTO ehdokkaat (ehdokas_id, sukunimi, etunimi, puolue, kotipaikkakunta, ika, miksi_eduskuntaan, mita_asioita_haluat_edistaa, ammatti, aanestysnumero) VALUES (?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, E.getEhdokas_Id());
			pstmt.setString(2, E.getEtunimi());
			pstmt.setString(3, E.getSukunimi());
			pstmt.setString(4, E.getPuolue());
			pstmt.setString(5, E.getKotipaikkakunta());
			pstmt.setInt(6, E.getIka());
			pstmt.setString(7, E.getMiksi_eduskuntaan());
			pstmt.setString(8, E.getMita_asioita_haluat_edistaa());
			pstmt.setString(9, E.getAmmatti());
			pstmt.setInt(10, E.getAanestysnumero());
			pstmt.executeUpdate();
			return readAllEhdokkaat();
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * Executes query to sql that updates given html element variables to canditates table in vaalikone database
	 * Returns to readAllEhdokkaat
	 */
	public ArrayList<ehdokkaat> updateEhdokkaat(ehdokkaat E) {
		try {
			String sql="update ehdokkaat set etunimi=?, sukunimi=?, puolue=?, kotipaikkakunta=?, ika=?, miksi_eduskuntaan=?, mita_asioita_haluat_edistaa=?, ammatti=?, aanestysnumero=?  where ehdokas_id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, E.getEtunimi());
			pstmt.setString(2, E.getSukunimi());
			pstmt.setString(3, E.getPuolue());
			pstmt.setString(4, E.getKotipaikkakunta());
			pstmt.setInt(5, E.getIka());
			pstmt.setString(6, E.getMiksi_eduskuntaan());
			pstmt.setString(7, E.getMita_asioita_haluat_edistaa());
			pstmt.setString(8, E.getAmmatti());
			pstmt.setInt(9, E.getAanestysnumero());
			pstmt.setInt(10, E.getEhdokas_Id());
			pstmt.executeUpdate();
			return readAllEhdokkaat();
		}
		catch(SQLException e) {
			return null;
		}
	}
	/**
	 * Executes query to sql that deletes candidate where selected "aanestysnumero" from canditates table in vaalikone database
	 * Returns to readAllEhdokkaat
	 */
	public ArrayList<ehdokkaat> deleteEhdokkaat(String aanestysnumero) {
		try {
			String sql="delete from ehdokkaat where aanestysnumero=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, aanestysnumero);
			pstmt.executeUpdate();
			return readAllEhdokkaat();
		}
		catch(SQLException e) {
			return null;
		}
	}

	/**
	 * Executes query to sql that selects canditate where "aanestysnumero" is one of a kind selected
	 * Returns the selected canditates info
	 */
	public ehdokkaat readEhdokas(String id) {
		ehdokkaat ehdokas=null;
		try {
			String sql="select * from ehdokkaat where aanestysnumero=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet RS=pstmt.executeQuery();
			while (RS.next()){
				ehdokas=new ehdokkaat();
				ehdokas.setEhdokas_Id(RS.getInt("ehdokas_id"));
				ehdokas.setSukunimi(RS.getString("sukunimi"));
				ehdokas.setEtunimi(RS.getString("etunimi"));
				ehdokas.setPuolue(RS.getString("puolue"));
				ehdokas.setKotipaikkakunta(RS.getString("kotipaikkakunta"));
				ehdokas.setIka(RS.getInt("ika"));
				ehdokas.setMiksi_eduskuntaan(RS.getString("miksi_eduskuntaan"));
				ehdokas.setMita_asioita_haluat_edistaa(RS.getString("mita_asioita_haluat_edistaa"));
				ehdokas.setAmmatti(RS.getString("ammatti"));
				ehdokas.setAanestysnumero(RS.getInt("aanestysnumero"));
			}
			return ehdokas;
		}
		catch(SQLException e) {
			return null;
		}
	}
	/**
	 * Executes query to sql that selects all questions and places them to a list
	 * Returns a list
	 */
	public ArrayList<kysymykset> readAllKysymykset() {
		ArrayList<kysymykset> list=new ArrayList<>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet RS=stmt.executeQuery("select * from kysymykset");
			while (RS.next()){
				kysymykset kysymys=new kysymykset();
				kysymys.setId(RS.getInt("kysymys_id"));
				kysymys.setKysymys(RS.getString("kysymys"));
				list.add(kysymys);
			}
			return list;
		}
		catch(SQLException e) {
			return null;
		}
	}
	/**
	 * Executes query to sql that updates given html element variables to questions table in vaalikone database
	 * Returns to readAllKysymykset
	 */
	public ArrayList<kysymykset> updateKysymykset(kysymykset K) {
		try {
			String sql="update kysymykset set kysymys=? where kysymys_id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, K.getKysymys());
			pstmt.setInt(2, K.getId());
			pstmt.executeUpdate();
			return readAllKysymykset();
		}
		catch(SQLException e) {
			return null;
		}
	}
	/**
	 * Executes query to sql that selects questions where "kysymys_id" is one of a kind selected
	 * Returns the selected question
	 */
	public kysymykset readKysymys(String id) {
		kysymykset kysymys=null;
		try {
			String sql="select * from kysymykset where kysymys_id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet RS=pstmt.executeQuery();
			while (RS.next()){
				kysymys=new kysymykset();
				kysymys.setId(RS.getInt("kysymys_id"));
				kysymys.setKysymys(RS.getString("kysymys"));
			}
			return kysymys;
		}
		catch(SQLException e) {
			return null;
		}
	}
	/**
	 * Executes query to sql that inserts html element variables to questions table in vaalikone database
	 * Returns to readAllKysymykset
	 */
	public ArrayList<kysymykset> addKysymys(kysymykset K) {
		String sql = "INSERT INTO kysymykset (kysymys_id, kysymys) VALUES (?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, K.getId());
			pstmt.setString(2, K.getKysymys());
			pstmt.executeUpdate();
			return readAllKysymykset();
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	
	}
	/**
	 * Executes query to sql that deletes question where selected "kysymys_id" from questions table in vaalikone database
	 * Returns to readAllKysymykset
	 */
	public ArrayList<kysymykset> deleteKysymys(String kysymys_id) {
		try {
			String sql="delete from kysymykset where kysymys_id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, kysymys_id);
			pstmt.executeUpdate();
			return readAllKysymykset();
		}
		catch(SQLException e) {
			return null;
		}
	}
}
