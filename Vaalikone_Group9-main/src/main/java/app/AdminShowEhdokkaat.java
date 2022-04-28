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

@WebServlet("/AdminShowEhdokkaat")
public class AdminShowEhdokkaat extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	 Dao dao = null;
	
	/**
	 * Method to Dao class and connecting to the database using url, user and password
	 */
	@Override
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "root", "Johannes1998");
	}
       
    public AdminShowEhdokkaat() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ehdokkaat> list=null;
		if (dao.getConnection()) {
			list=dao.readAllEhdokkaat();
		}
		else {
			System.out.println("No connection to database");
		}
		
	
		request.setAttribute("EhdokasLista", list);

		RequestDispatcher rd=request.getRequestDispatcher("/jsp/AdminShowEhdokkaat.jsp");
		rd.forward(request, response);
		
	}	

}