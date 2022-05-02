package rest;

import java.util.List;
import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import data.ehdokkaat;
import data.kysymykset;
import data.vastaukset;

@Path("/vaalikoneservice")
public class VaalikoneService {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("vaalikone");
	
	@GET
	@Path("/readvastaus")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void readAnswers(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<vastaukset> list = em.createQuery("select v from Vastaukset v").getResultList();
		em.getTransaction().commit();
		em.close();
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/vastaukset.jsp");
		request.setAttribute("VastauksetLista", list);
		
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
