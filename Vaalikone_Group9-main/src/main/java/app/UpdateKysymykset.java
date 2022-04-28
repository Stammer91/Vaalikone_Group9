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
import data.kysymykset;;

@WebServlet(
	  name = "UpdateKysymys",
	  urlPatterns = {"/updatekysymys"}
	)

public class UpdateKysymykset extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 private Dao dao;
	
	/**
	 * Method to Dao class and connecting to the database using url, user and password
	 */
	@Override
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "root", "Johannes1998");
	}
    public UpdateKysymykset() {
        super();
    }

    
	/**
	 * Sens redirect link to response to get from admin.html
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("admin.html");
	}
	


	/**
	 * Gets question parameters from the jsp site, then updates them if edited and response sends updated list of questions to admin page
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
		     throws IOException, ServletException {
		
		String id_string = request.getParameter("id");
		String kysymys = request.getParameter("kysymys");
		
		int id = Integer.parseInt(id_string);
		
		kysymykset K=new kysymykset(id, kysymys);
		
		
			ArrayList<kysymykset> list=null;
			if (dao.getConnection()) {
				list=dao.updateKysymykset(K);
			}
			else {
				System.out.println("No connection to database");
			}
			
			request.setAttribute("KysymysLista", list);
			RequestDispatcher rd=request.getRequestDispatcher("/jsp/AdminShowKysymykset.jsp");
			rd.forward(request, response);
	}

}
