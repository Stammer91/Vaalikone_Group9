package rest;

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import dao.Dao;
import data.ehdokkaatMTM;
import data.kysymyksetMTM;
import data.vastauksetMTM;

@Path("/vaalikoneservice")
public class VaalikoneService {
	
	private Dao dao = new Dao("jdbc:mysql://localhost:3306/vaalikone?useSSL=false", "root", "Johannes1998");
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("vaalikone");
	
	@Context HttpServletRequest request;
	@Context HttpServletResponse response;
	
	
	@GET
	@Path("/readvastaukset")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void readVastaukset() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<vastauksetMTM> list = em.createQuery("select v from vastauksetMTM v").getResultList();
		em.getTransaction().commit();
		em.close();
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/ShowVastaukset.jsp");
		request.setAttribute("VastausLista", list);
		
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	@GET
	@Path("/readvastaus")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<vastauksetMTM> readVastaus() {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		List<vastauksetMTM> list=em.createQuery("select v from vastauksetMTM v").getResultList();		
		em.getTransaction().commit();
		return list;
	}	
	
	@POST
	@Path("/addvastaus")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<vastauksetMTM> addVastaus(vastauksetMTM vastaus) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(vastaus);
		em.getTransaction().commit();
		List<vastauksetMTM> list=readVastaus();		
		return list;
	}
	
	@PUT
	@Path("/updatevastaus")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<vastauksetMTM> updateVastaus(vastauksetMTM vastaus) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		vastauksetMTM v=em.find(vastauksetMTM.class, vastaus.getId());
		if (v!=null) {
			em.merge(vastaus);
		}
		em.getTransaction().commit();
		List<vastauksetMTM> list=readVastaus();		
		return list;
	}	
	@DELETE
	@Path("/deletevastaus/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<vastauksetMTM> deleteVastaus(@PathParam("id") int id) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		vastauksetMTM v=em.find(vastauksetMTM.class, id);
		if (v!=null) {
			em.remove(v);
		}
		em.getTransaction().commit();
		List<vastauksetMTM> list=readVastaus();		
		return list;
	}	
	@GET
	@Path("/deletevastaus/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteVastausByGet(@PathParam("id") int id, 
			@Context HttpServletRequest request,
			@Context HttpServletResponse response
			) {
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		vastauksetMTM v=em.find(vastauksetMTM.class, id);
		if (v!=null) {
			em.remove(v);
		}
		em.getTransaction().commit();
		List<vastauksetMTM> list=readVastaus();		
		
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/ShowVastaukset.jsp");
		request.setAttribute("VastausLista", list);
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	@GET
	@Path("/readall")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void readAll() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<ehdokkaatMTM> list = em.createQuery("select e from ehdokkaatMTM e").getResultList();
		List<kysymyksetMTM> list2 = em.createQuery("select k from kysymyksetMTM k").getResultList();
		List<vastauksetMTM> list3 = em.createQuery("select v from vastauksetMTM v").getResultList();
		em.getTransaction().commit();
		em.close();
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/ShowVastaukset.jsp");
		request.setAttribute("EhdokasLista", list);
		request.setAttribute("KysymysLista", list2);
		request.setAttribute("VastausLista", list3);
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
