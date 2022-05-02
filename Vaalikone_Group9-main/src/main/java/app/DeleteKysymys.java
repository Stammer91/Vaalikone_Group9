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
import data.kysymykset;

 
/**
 * Date: 2.5 2022
 * This is a application for deleting questions
 * @author Oskari
 *
 */
@WebServlet("/DeleteKysymys")
public class DeleteKysymys extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	 Dao dao = null;
	
	/**
	 * Method to Dao class and connecting to the database using url, user and password
	 */
	@Override
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "root", "Johannes1998");
	}
       
    public DeleteKysymys() {
        super();
    }
    /**
	 * Method to selecting the right questions by the question_id aswll creating a list, checking from dao class the connection and reading all the questions after delete.
	 * Sending the list as a reguest to Admin page to show questions in jsp file.
	 */
public void doGet(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException, ServletException {
		String id=request.getParameter("kysymys_id");
		ArrayList<kysymykset> list=null;
		if (dao.getConnection()) {
			list=dao.deleteKysymys(id);
	}
		request.setAttribute("KysymysLista", list);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/AdminShowKysymykset.jsp");
		rd.forward(request, response);
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
