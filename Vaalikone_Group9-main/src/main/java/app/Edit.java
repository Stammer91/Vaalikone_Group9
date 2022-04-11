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
 * Servlet implementation class Edit
 */
@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 Dao dao = null;
	
	@Override
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "root", "Johannes1998");
	}
    public Edit() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ehdokkaat> list = null;
		if (dao.getConnection()) {
			list = dao.readAllEhdokkaat();
		} else {
			System.out.println("No connection to database");
		}
		
		request.setAttribute("EhdokasLista", list);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/EditEhdokkaat.jsp");
		rd.forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
		     throws IOException, ServletException {
		String ehdokas_id_string = request.getParameter("ehdokas_id");
		String etunimi = request.getParameter("etunimi");
		String sukunimi = request.getParameter("sukunimi");
		String puolue = request.getParameter("puolue");
		String kotipaikkakunta = request.getParameter("kotipaikkakunta");
		String ika_string = request.getParameter("ika");
		String miksi_eduskuntaan = request.getParameter("miksi_eduskuntaan");
		String mita_asioita_haluat_edistaa = request.getParameter("mita_asioita_haluat_edistaa");
		String ammatti = request.getParameter("ammatti");
		String aanestysnumero_string = request.getParameter("aanestysnumero");

		int ehdokas_id = Integer.parseInt(ehdokas_id_string);
		int ika = Integer.parseInt(ika_string);
		int aanestysnumero = Integer.parseInt(aanestysnumero_string);
		
		ehdokkaat E=new ehdokkaat(ehdokas_id, etunimi, sukunimi, puolue, kotipaikkakunta, ika, miksi_eduskuntaan,
				mita_asioita_haluat_edistaa, ammatti, aanestysnumero);
		
		dao.updateEhdokkaat(E);
		
			ArrayList<ehdokkaat> list=null;
			if (dao.getConnection()) {
				list=dao.readAllEhdokkaat();
			}
			else {
				System.out.println("No connection to database");
			}
			
			request.setAttribute("EhdokasLista", list);
			RequestDispatcher rd=request.getRequestDispatcher("/jsp/ShowEhdokkaat.jsp");
			rd.forward(request, response);
	}

}
