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

@WebServlet(
    name = "Delete",
    urlPatterns = {"/Delete"}
)
public class Delete extends HttpServlet {
	private Dao dao;
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "root", "Johannes1998");
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException, ServletException {
		String id=request.getParameter("aanestysnumero");
		ArrayList<ehdokkaat> list=null;
		if (dao.getConnection()) {
			list=dao.deleteEhdokkaat(id);
		}
		request.setAttribute("EhdokasLista", list);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/ShowEhdokkaat.jsp");
		rd.forward(request, response);
	}
}
