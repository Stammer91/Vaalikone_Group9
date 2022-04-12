package app;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import data.kysymykset;


@WebServlet("/readtoupdatekysymys")
public class ReadToUpdateKysymykset extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao;
	public void init() {
		dao = new Dao("jdbc:mysql://localhost:3306/vaalikone", "root", "Johannes1998");
	}
       
    public ReadToUpdateKysymykset() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("kysymys_id");
		
		kysymykset kysymys=null;
		if (dao.getConnection()) {
			kysymys=dao.readKysymys(id);
		}
		request.setAttribute("kysymys", kysymys);
		
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/UpdateKysymykset.jsp");
		rd.forward(request, response);
	}
}
