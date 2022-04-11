package app;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< Updated upstream:Vaalikone_Group9-main/src/main/java/app/Edit.java
/**
 * Servlet implementation class Edit
 */
@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit() {
=======
import dao.Dao;
import data.ehdokkaat;

@WebServlet(
	  name = "Update",
	  urlPatterns = {"/update"}
	)

public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 private Dao dao;
	
	@Override
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "root", "Johannes1998");
	}
    public Update() {
>>>>>>> Stashed changes:Vaalikone_Group9-main/src/main/java/app/Update.java
        super();
        // TODO Auto-generated constructor stub
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< Updated upstream:Vaalikone_Group9-main/src/main/java/app/Edit.java
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
=======
		
		response.sendRedirect("index.html");
>>>>>>> Stashed changes:Vaalikone_Group9-main/src/main/java/app/Update.java
	}

<<<<<<< Updated upstream:Vaalikone_Group9-main/src/main/java/app/Edit.java
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
=======

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
		     throws IOException, ServletException {
		String ehdokasid_string = request.getParameter("ehdokas_id");
		String etunimi = request.getParameter("etunimi");
		String sukunimi = request.getParameter("sukunimi");
		String puolue = request.getParameter("puolue");
		String kotipaikkakunta = request.getParameter("kotipaikkakunta");
		String ika_string = request.getParameter("ika");
		String miksi_eduskuntaan = request.getParameter("miksi_eduskuntaan");
		String mita_asioita_haluat_edistaa = request.getParameter("mita_asioita_haluat_edistaa");
		String ammatti = request.getParameter("ammatti");
		String aanestysnumero_string = request.getParameter("aanestysnumero");

		int ika = Integer.parseInt(ika_string);
		int aanestysnumero = Integer.parseInt(aanestysnumero_string);
		int ehdokas_id = Integer.parseInt(ehdokasid_string);
		
		ehdokkaat E=new ehdokkaat(ehdokas_id, etunimi, sukunimi, puolue, kotipaikkakunta, ika, miksi_eduskuntaan,
				mita_asioita_haluat_edistaa, ammatti, aanestysnumero);
		
		
			ArrayList<ehdokkaat> list=null;
			if (dao.getConnection()) {
				list=dao.updateEhdokkaat(E);
			}
			else {
				System.out.println("No connection to database");
			}
			
			request.setAttribute("EhdokasLista", list);
			RequestDispatcher rd=request.getRequestDispatcher("/jsp/AdminShowEhdokkaat.jsp");
			rd.forward(request, response);
>>>>>>> Stashed changes:Vaalikone_Group9-main/src/main/java/app/Update.java
	}

}
