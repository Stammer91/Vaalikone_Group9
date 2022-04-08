package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.ehdokkaat;

import java.sql.Connection;

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
	public ArrayList<ehdokkaat> updateEhdokkaat(ehdokkaat E) {
		try {
			String sql="update ehdokkaat set etunimi=? where id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, E.getEtunimi());
			pstmt.setInt(2, E.getEhdokas_Id());
			pstmt.executeUpdate();
			return readAllEhdokkaat();
		}
		catch(SQLException e) {
			return null;
		}
	}
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

	public ehdokkaat readEhdokas(String id) {
		ehdokkaat ehdokas=null;
		try {
			String sql="select * from ehdokkaat where id=?";
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
}
