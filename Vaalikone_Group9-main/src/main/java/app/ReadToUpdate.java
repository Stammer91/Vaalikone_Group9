package app;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import data.ehdokkaat;

/**
 * Date: 2.5 2022
 * This is a application for reading the canditate and preparing for update
 * @author Oskari
 *
 */
@WebServlet("/readtoupdate")
public class ReadToUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao;
	
	/**
	 * Method to Dao class and connecting to the database using url, user and password
	 */
	public void init() {
		dao = new Dao("jdbc:mysql://localhost:3306/vaalikone", "root", "Johannes1998");
	}
       
    public ReadToUpdate() {
        super();
        
    }
    /**
	 * Method to selecting the right canditate by the votingnumber, checking from dao class the connection and reading all the information of selected canditate.
	 * Sending the canditate as a reguest to Admin page to update in jsp file.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("aanestysnumero");
		
		ehdokkaat ehdokas=null;
		if (dao.getConnection()) {
			ehdokas=dao.readEhdokas(id);
		}
		request.setAttribute("ehdokas", ehdokas);
		
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/UpdateEhdokkaat.jsp");
		rd.forward(request, response);
	}
}
