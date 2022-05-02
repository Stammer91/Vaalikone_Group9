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
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	 Dao dao = null;
	
	/**
	 * Method to Dao class and connecting to the database using url, user and password
	 */
	@Override
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "root", "Johannes1998");
	}
       
    public Delete() {
        super();
    }

public void doGet(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException, ServletException {
		String id=request.getParameter("aanestysnumero");
		ArrayList<ehdokkaat> list=null;
		if (dao.getConnection()) {
			list=dao.deleteEhdokkaat(id);
	}
		request.setAttribute("EhdokasLista", list);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/AdminShowEhdokkaat.jsp");
		rd.forward(request, response);
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
