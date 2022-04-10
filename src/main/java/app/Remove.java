package app;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Remove
 */
@WebServlet("/Remove")
public class Remove extends HttpServlet {
	private static final long serialVersionUID = 1L;
<<<<<<< Updated upstream:src/main/java/app/Remove.java
=======
	private Dao dao;
	public void init() {
		dao = new Dao("jdbc:mysql://localhost:3306/vaalikone", "root", "Johannes1998");
	}

>>>>>>> Stashed changes:Vaalikone_Group9-main/src/main/java/app/ReadToUpdate.java
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Remove() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
<<<<<<< Updated upstream:src/main/java/app/Remove.java
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
=======
		String id=request.getParameter("id");
		ehdokkaat ehdokas=null;
		if (dao.getConnection()) {
			ehdokas=dao.readEhdokas(id);
		}
		request.setAttribute("ehdokas", ehdokas);
		
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/EditEhdokkaat.jsp");
		rd.forward(request, response);
>>>>>>> Stashed changes:Vaalikone_Group9-main/src/main/java/app/ReadToUpdate.java
	}

}
