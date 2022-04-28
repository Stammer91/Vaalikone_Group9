package app;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import data.ehdokkaat;


/**
 * Date: 14.4 2022
 * This is a application for adding new canditates
 * @author Oskari
 *
 */
@WebServlet("/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Dao dao = null;
	
	/**
	 * Method to Dao class and connecting to the database using url, user and password
	 */
	public void init() {
		dao = new Dao("jdbc:mysql://localhost:3306/vaalikone", "root", "Johannes1998");
	}
       
    public Add() {
        super();   
    }

	
	/**
	 * Method to create a list, checking from dao class the connection and reading all the canditate information.
	 * Sending the list as a reguest to Adding new canditates jsp file
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<ehdokkaat> list = null;
		if (dao.getConnection()) {
			list = dao.readAllEhdokkaat();
		} else {
			System.out.println("No connection to database");
		}
		
		request.setAttribute("EhdokasLista", list);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/AddEhdokkaat.jsp");
		rd.forward(request, response);
	}

	
	/**
	 * Gets all the new canditates information from jsp site and adds the canditate to database
	 * Request sends all the canditates to admin page
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ehdokas_id_string = request.getParameter("ehdokas_id");
		String etunimi = request.getParameter("etunimi");
		String sukunimi = request.getParameter("sukunimi");
		String puolue = request.getParameter("puolue");
		String kotipaikkakunta = request.getParameter("kotipaikkakunta");
		String ika_string = request.getParameter("ika");
		String miksi_eduskuntaan = request.getParameter("miksi_eduskuntaan");
		String mita_asioita_haluat_edistaa = request.getParameter("mita_asioita_haluat_edistaa");
		String ammatti = request.getParameter("ammatti");
		String aanestysnumero_string = request.getParameter("aanestysnumero");

		int ehdokas_id = Integer.parseInt(ehdokas_id_string);
		int ika = Integer.parseInt(ika_string);
		int aanestysnumero = Integer.parseInt(aanestysnumero_string);
		
		ehdokkaat E=new ehdokkaat(ehdokas_id, etunimi, sukunimi, puolue, kotipaikkakunta, ika, miksi_eduskuntaan,
				mita_asioita_haluat_edistaa, ammatti, aanestysnumero);
		
		dao.addEhdokkaat(E);
		
		ArrayList<ehdokkaat> list=null;
		if (dao.getConnection()) {
			list=dao.readAllEhdokkaat();
		} else {
			System.out.println("No connection to database");
		}
		
		request.setAttribute("EhdokasLista", list);
		
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/AdminShowEhdokkaat.jsp");
		rd.forward(request, response);
	}

}
