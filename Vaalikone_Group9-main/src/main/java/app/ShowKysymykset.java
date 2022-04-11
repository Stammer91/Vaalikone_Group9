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

@WebServlet("/ShowKysymykset")
public class ShowKysymykset extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	 Dao dao = null;
	
	@Override
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "root", "Johannes1998");
	}
       
    public ShowKysymykset() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<kysymykset> list=null;
		if (dao.getConnection()) {
			list=dao.readAllKysymykset();
		}
		else {
			System.out.println("No connection to database");
		}
		
	
		request.setAttribute("KysymysLista", list);

		RequestDispatcher rd=request.getRequestDispatcher("/jsp/ShowKysymykset.jsp");
		rd.forward(request, response);
		
	}	

}