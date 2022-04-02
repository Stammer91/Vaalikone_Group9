package dao;

import java.sql.DriverManager;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.ehdokkaat;

import java.sql.Connection;

public class dao {
	private String url;
	private String user;
	private String pass;
	private Connection conn;
	
	public dao(String url, String user, String pass) {
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
				ehdokkaat ehdokkaat=new ehdokkaat();
				ehdokkaat.setEhdokas_Id(RS.getInt("ehdokas_id"));
				ehdokkaat.setSukunimi(RS.getString("sukunimi"));
				ehdokkaat.setEtunimi(RS.getString("etunimi"));
				ehdokkaat.setPuolue(RS.getString("puolue"));
				ehdokkaat.setKotipaikkakunta(RS.getString("kotipaikkakunta"));
				ehdokkaat.setIka(RS.getInt("ika"));
				ehdokkaat.setMiksi_eduskuntaan(RS.getString("miksi_eduskuntaan"));
				ehdokkaat.setMita_asioita_haluat_edistaa(RS.getString("mita_asioita_haluat_edistaa"));
				ehdokkaat.setAmmatti(RS.getString("ammatti"));
				list.add(ehdokkaat);
			}
			return list;
		}
		catch(SQLException e) {
			return null;
		}
	}
	public ArrayList<ehdokkaat> updateEhdokkaat(ehdokkaat E) {
		try {
			String sql="update ehdokkaat set Etunimi=? where id=?";
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
	public ArrayList<ehdokkaat> deleteEhdokkaat(String id) {
		try {
			String sql="delete from ehdokkaat where id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			return readAllEhdokkaat();
		}
		catch(SQLException e) {
			return null;
		}
	}

	public ehdokkaat readEhdokkaat(String id) {
		ehdokkaat ehdokkaat=null;
		try {
			String sql="select * from ehdokkaat where id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet RS=pstmt.executeQuery();
			while (RS.next()){
				ehdokkaat=new ehdokkaat();
				ehdokkaat.setEhdokas_Id(RS.getInt("ehdokas_id"));
				ehdokkaat.setSukunimi(RS.getString("sukunimi"));
				ehdokkaat.setEtunimi(RS.getString("etunimi"));
				ehdokkaat.setPuolue(RS.getString("puolue"));
				ehdokkaat.setKotipaikkakunta(RS.getString("kotipaikkakunta"));
				ehdokkaat.setIka(RS.getInt("ika"));
				ehdokkaat.setMiksi_eduskuntaan(RS.getString("miksi_eduskuntaan"));
				ehdokkaat.setMita_asioita_haluat_edistaa(RS.getString("mita_asioita_haluat_edistaa"));
				ehdokkaat.setAmmatti(RS.getString("ammatti"));
			}
			return ehdokkaat;
		}
		catch(SQLException e) {
			return null;
		}
	}
}