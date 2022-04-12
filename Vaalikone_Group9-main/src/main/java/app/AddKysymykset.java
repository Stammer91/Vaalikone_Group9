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


@WebServlet("/AddKysymykset")

public class AddKysymykset extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Dao dao = null;
	
	public void init() {
		dao = new Dao("jdbc:mysql://localhost:3306/vaalikone", "root", "Johannes1998");
	}
       
    public AddKysymykset() {
        super();   
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		ArrayList<kysymykset> list = null;
		if (dao.getConnection()) {
			list = dao.readAllKysymykset();
		} else {
			System.out.println("No connection to database");
		}
		
		request.setAttribute("Kysymys", list);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/AddKysymykset.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String kysymys_id_string = request.getParameter("kysymys_id");
		String kysymys = request.getParameter("kysymys");
		
		kysymykset K=new kysymykset();
		
		dao.addKysymys(K);
		
		ArrayList<kysymykset> list=null;
		if (dao.getConnection()) {
			list=dao.readAllKysymykset();
		} else {
			System.out.println("No connection to database");
		}
		
		request.setAttribute("KysymysLista", list);
		
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/AddKysymykset.jsp");
		rd.forward(request, response);
	}

}
