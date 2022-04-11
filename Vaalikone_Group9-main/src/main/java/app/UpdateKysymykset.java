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
	
	@Override
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "root", "Johannes1998");
	}
    public UpdateKysymykset() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("admin.html");
	}
	


	public void doPost(HttpServletRequest request, HttpServletResponse response) 
		     throws IOException, ServletException {
		
		String id = request.getParameter("kysymys_id");
		String kysymys = request.getParameter("kysymys");
		
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
